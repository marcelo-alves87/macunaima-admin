package org.macunaima.domain;

import com.mongodb.DBObject;

public class Filial extends Entity {

	private String nome;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("nome", getNome());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setNome((String) dbObject.get("nome"));
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

}
