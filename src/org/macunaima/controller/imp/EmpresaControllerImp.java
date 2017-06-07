package org.macunaima.controller.imp;

import java.util.Arrays;
import java.util.Vector;
import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.macunaima.controller.EmpresaController;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Empresa;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class EmpresaControllerImp implements EmpresaController {

	private static MongoClient mongoClient;

	@Override
	public Vector<Empresa> find(String search) {
		checkConnection();
		DBCollection empresasCollection = getEmpresasCollection();
		DBCursor dbCursor = null;
		if (search != null && !search.isEmpty()) {
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("nome", Pattern.compile(".*" + search + ".*", Pattern.CASE_INSENSITIVE));
			dbCursor = empresasCollection.find(whereQuery);
		} else {
			dbCursor = empresasCollection.find();
		}
		dbCursor.sort(new BasicDBObject("nome", 1));
		Vector<Empresa> empresas = new Vector<Empresa>();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			empresas.add(Empresa.toEmpresa(dbObject));
		}
		return empresas;
	}

	private void openConnection() {
		MongoCredential mongoCredential = MongoCredential.createScramSha1Credential("myTester", "macunaima",
				"xyz123".toCharArray());
		mongoClient = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));
	}

	private DBCollection getEmpresasCollection() {
		DB db = mongoClient.getDB("macunaima");
		return db.getCollection("empresas");
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

	private void checkConnection() {
		if (!isConnectionOpened()) {
			openConnection();
		}
	}

	@Override
	public Callback persist(Empresa empresa) {
		checkConnection();
		DBCollection empresasCollection = getEmpresasCollection();
		DBObject dbObject = empresa.fromEmpresa();
		if(empresa.isNew()) {
			empresasCollection.insert(dbObject);
		} else {
			BasicDBObject whereQuery = new BasicDBObject();
			whereQuery.put("_id", new ObjectId(empresa.getId()));
			empresasCollection.update(whereQuery, dbObject);
		}
		return new Callback() {
			
			@Override
			public int callBack() {
				return 1;
			}
		};
		
	}

	@Override
	public Callback delete(Empresa empresa) {
		if(empresa == null || empresa.isNew()) {
			return new Callback() {
				
				@Override
				public int callBack() {
					return 0;
				}
			};
		} else {
			checkConnection();
			DBCollection empresasCollection = getEmpresasCollection();
			DBObject dbObject = empresa.fromEmpresa();
			empresasCollection.remove(dbObject);
			return new Callback() {
				
				@Override
				public int callBack() {
					// TODO Auto-generated method stub
					return 1;
				}
			};
		}
	}

}
