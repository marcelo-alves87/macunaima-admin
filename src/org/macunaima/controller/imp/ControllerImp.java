package org.macunaima.controller.imp;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.macunaima.controller.Controller;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public abstract class ControllerImp<T extends Entity> implements Controller<T> {

	private MongoClient mongoClient;
	private static String DEFAULT_DATABASE = "macunaima";

	@Override
	public Vector<T> find(String search) {
		checkConnection();
		DBCursor dbCursor = findDBCursor(getDefaultCollection(), getDefaultParameters(), search);
		Vector<T> entities = new Vector<T>();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			T t = convertFromDBObject(dbObject);
			entities.add(t);
		}
		return entities;
	}

	protected abstract String[] getDefaultParameters();

	protected abstract DBCollection getDefaultCollection();

	protected T convertFromDBObject(DBObject dbObject) {
		Class<T> clazz = getClazz();
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.fromEntity(dbObject);
		return t;
	}

	protected Callback persist(Entity entity, DBCollection collection, boolean isAdministrador) {
		if (isAdministrador) {
			checkConnection();
			DBObject dbObject = new BasicDBObject();
			entity.to(dbObject);
			if (entity.isNew()) {
				collection.insert(dbObject);
			} else {
				BasicDBObject whereQuery = new BasicDBObject();
				whereQuery.put("_id", new ObjectId(entity.getId()));
				collection.update(whereQuery, dbObject);
			}
			return new Callback() {

				@Override
				public int callBack() {
					return 1;
				}
			};
		} else {
			return new Callback() {

				@Override
				public int callBack() {
					return 0;
				}
			};
		}
	}

	@Override
	public Callback persist(T entity, boolean isAdministrador) {
		return persist(entity, getDefaultCollection(), isAdministrador);
	}

	@Override
	public Callback delete(Entity entity, boolean isAdministrador) {
		return delete(entity, getDefaultCollection(), isAdministrador);
	}

	protected Callback delete(Entity entity, DBCollection collection, boolean isAdministrador) {
		if (entity == null || entity.isNew() || !isAdministrador) {
			return new Callback() {

				@Override
				public int callBack() {
					return 0;
				}
			};
		} else {
			checkConnection();
			DBObject dbObject = new BasicDBObject();
			dbObject.put("_id", new ObjectId(entity.getId()));
			collection.findAndRemove(dbObject);
			return new Callback() {

				@Override
				public int callBack() {
					return 1;
				}
			};
		}
	}

	private void openConnection() {
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("myTester", "macunaima",
				"xyz123".toCharArray());
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));
	}

	private boolean isConnectionOpened() {
		boolean isConnectionOpened = false;
		try {
			String connectionPoint = mongoClient.getConnectPoint();
			if (connectionPoint != null) {
				isConnectionOpened = true;
			}
		} catch (Exception e) {
		}
		return isConnectionOpened;
	}

	protected void checkConnection() {
		if (!isConnectionOpened()) {
			openConnection();
		}
	}

	@Override
	public Vector<T> findAll() {
		return find(null);
	}

	protected DBCollection getCollection(String collection) {
		DB db = getDefaultDB();
		return db.getCollection(collection);
	}

	@SuppressWarnings("deprecation")
	protected DB getDefaultDB() {
		return mongoClient.getDB(DEFAULT_DATABASE);
	}

	protected abstract Class<T> getClazz();

	protected DBObject findById(String id, String collection) {
		ObjectId objectId = new ObjectId(id);
		return getCollection(collection).findOne(objectId);
	}

	@Override
	public T findById(String id) {
		checkConnection();
		DBObject dbObject = getDefaultCollection().findOne(new ObjectId(id));
		return convertFromDBObject(dbObject);
	}

	protected DBCursor findDBCursor(DBCollection collection, String parameter, String search) {
		return findDBCursor(collection, new String[] { parameter }, search);
	}

	protected DBCursor findDBCursor(DBCollection collection, String[] parameters, String search) {
		checkConnection();
		DBCursor dbCursor = null;
		if (search != null && !search.isEmpty()) {
			BasicDBList basicDBList = new BasicDBList();
			for (String parameter : parameters) {
				basicDBList.add(
						new BasicDBObject(parameter, Pattern.compile(".*" + search + ".*", Pattern.CASE_INSENSITIVE)));
			}
			BasicDBObject whereQuery = new BasicDBObject("$or", basicDBList);
			dbCursor = collection.find(whereQuery).sort(new BasicDBObject("dataCadastramento", -1));
		} else {
			dbCursor = collection.find().sort(new BasicDBObject("dataCadastramento", -1));
		}
		return dbCursor;
	}

	protected DBCursor findDBCursor(DBCollection collection, String parameter, List<String> search) {
		checkConnection();
		DBCursor dbCursor = null;
		if (search != null && !search.isEmpty()) {
			BasicDBList basicDBList = new BasicDBList();
			for (String search1 : search) {
				basicDBList.add(
						new BasicDBObject(parameter, Pattern.compile(".*" + search1 + ".*", Pattern.CASE_INSENSITIVE)));
			}
			BasicDBObject whereQuery = new BasicDBObject("$or", basicDBList);
			dbCursor = collection.find(whereQuery).sort(new BasicDBObject("dataCadastramento", -1));
		} else {
			dbCursor = collection.find().sort(new BasicDBObject("dataCadastramento", -1));
		}
		return dbCursor;
	}

}
