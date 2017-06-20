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
		if (dbObject != null) {
			this.id = dbObject.get("_id").toString();
			this.dataCadastramento = (Date) dbObject.get("dataCadastramento");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
