package org.macunaima.domain;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Empresa {

	private String id;
	private String nome;
	private String descontoCredito;
	private String descontoAVista;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescontoCredito() {
		return descontoCredito;
	}

	public void setDescontoCredito(String descontoCredito) {
		this.descontoCredito = descontoCredito;
	}

	public String getDescontoAVista() {
		return descontoAVista;
	}

	public void setDescontoAVista(String descontoAVista) {
		this.descontoAVista = descontoAVista;
	}

	public static Empresa toEmpresa(DBObject dbObject) {
		Empresa empresa = new Empresa();
		empresa.setId(((ObjectId) dbObject.get("_id")).toString());
		empresa.setNome((String) dbObject.get("nome"));
		empresa.setDescontoCredito((String) dbObject.get("descontoCredito"));
		empresa.setDescontoAVista((String) dbObject.get("descontoAVista"));
		return empresa;
	}

	public DBObject fromEmpresa() {
		DBObject dbObject = new BasicDBObject();
		if (id != null) {
			dbObject.put("_id", new ObjectId(getId()));
		}
		dbObject.put("nome", getNome());
		dbObject.put("descontoCredito", getDescontoCredito());
		dbObject.put("descontoAVista", getDescontoAVista());
		return dbObject;
	}
	
	public boolean isNew() {
		return this.id == null;
	}

}
