package org.macunaima.domain;

import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.DBObject;

public abstract class Entity {

	private String id;
	private Date dataCadastramento;

	public String getId() {
		return id;
	}

	public Date getDataCadastramento() {
		return dataCadastramento;
	}

	public void setDataCadastramento(Date dataCadastramento) {
		this.dataCadastramento = dataCadastramento;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract void to(DBObject dbObject);

	public abstract void fromEntity(DBObject dbObject);

	public boolean isNew() {
		return this.id == null;
	}

	private boolean hasDataCadastramento() {
		return this.dataCadastramento != null;
	}

	protected void put(DBObject dbObject) {
		if (!isNew())
			dbObject.put("_id", new ObjectId(getId()));
		if (!hasDataCadastramento())
			dataCadastramento = new Date();
		dbObject.put("dataCadastramento", dataCadastramento);
	}

	protected void get(DBObject dbObject) {
		this.id = dbObject.get("_id").toString();
		this.dataCadastramento = (Date) dbObject.get("dataCadastramento");
	}
	
	public abstract Entity create();

}
