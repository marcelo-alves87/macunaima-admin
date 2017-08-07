package org.macunaima.domain;

import java.io.File;

import com.mongodb.DBObject;

public class Filial extends Entity {

	private String nome;
	private String logoName;
	private File logotipo;
	private String unidade;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("nome", getNome());
		dbObject.put("logoName", getLogoName());
		dbObject.put("unidade", getUnidade());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setNome((String) dbObject.get("nome"));
			setLogoName((String) dbObject.get("logoName"));
			setUnidade((String) dbObject.get("unidade"));
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
		return nome + " - " + unidade;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

	public File getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(File logotipo) {
		this.logotipo = logotipo;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

}
