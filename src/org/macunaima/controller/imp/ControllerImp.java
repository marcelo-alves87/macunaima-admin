package org.macunaima.controller.imp;

import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.macunaima.controller.Controller;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;

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
		DBCursor dbCursor = findDBCursor(getDefaultCollection(), getDefaultParameter(), search);
		Vector<T> entities = new Vector<T>();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			T t = convertFromDBObject(dbObject);
			entities.add(t);
		}
		return entities;
	}

	protected abstract String getDefaultParameter();

	protected abstract DBCollection getDefaultCollection();

	protected T convertFromDBObject(DBObject dbObject) {
		Class<T> clazz = getInstance();
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

	@Override
	public Callback persist(T entity) {
		checkConnection();
		DBCollection collection = getDefaultCollection();
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
	}

	@Override
	public Callback delete(Entity entity) {
		return delete(entity, getDefaultCollection());
	}

	protected Callback delete(Entity entity, DBCollection collection) {
		if (entity == null || entity.isNew()) {
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
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB(DEFAULT_DATABASE);
		return db.getCollection(collection);
	}

	protected abstract Class<T> getInstance();

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

	protected DBCursor findDBCursor(DBCollection collection, String parameters, String search) {
		checkConnection();
		DBCursor dbCursor = null;
		if (search != null) {
			BasicDBObject whereQuery = new BasicDBObject();
			if (!search.isEmpty())
				whereQuery.put(parameters, Pattern.compile(".*" + search + ".*", Pattern.CASE_INSENSITIVE));
			dbCursor = collection.find(whereQuery).sort(new BasicDBObject("dataCadastramento", -1));
		} else {
			dbCursor = collection.find().sort(new BasicDBObject("dataCadastramento", -1));
		}
		return dbCursor;
	}
}
