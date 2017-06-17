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
	public Vector<T> find(String... search) {
		checkConnection();
		DBCollection collection = getDefaultCollection();
		DBCursor dbCursor = null;
		if (search != null) {
			BasicDBObject whereQuery = new BasicDBObject();
			for (String search1 : search) {
				if (!search1.isEmpty())
					whereQuery.put("nome", Pattern.compile(".*" + search1 + ".*", Pattern.CASE_INSENSITIVE));
			}
			dbCursor = collection.find(whereQuery).sort(new BasicDBObject("dataCadastramento", -1));
		} else {
			dbCursor = collection.find().sort(new BasicDBObject("dataCadastramento", -1));
		}
		Vector<T> entities = new Vector<T>();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Class<T> clazz = getInstance();
			try {
				T t = clazz.newInstance();
				t.fromEntity(dbObject);
				entities.add(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return entities;
	}

	protected abstract DBCollection getDefaultCollection();

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
	public Callback delete(T entity) {
		if (entity == null || entity.isNew()) {
			return new Callback() {

				@Override
				public int callBack() {
					return 0;
				}
			};
		} else {
			checkConnection();
			DBCollection empresasCollection = getDefaultCollection();
			DBObject dbObject = new BasicDBObject();
			dbObject.put("_id", new ObjectId(entity.getId()));
			empresasCollection.findAndRemove(dbObject);
			return new Callback() {

				@Override
				public int callBack() {
					// TODO Auto-generated method stub
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
}
