package org.macunaima.domain;

import com.mongodb.DBObject;

public class Empresa extends Entity {

	private String nome;
	private String descontoCredito;
	private String descontoAVista;

	public Empresa() {
		super();
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

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("nome", getNome());
		dbObject.put("descontoCredito", getDescontoCredito());
		dbObject.put("descontoAVista", getDescontoAVista());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setNome((String) dbObject.get("nome"));
			setDescontoCredito((String) dbObject.get("descontoCredito"));
			setDescontoAVista((String) dbObject.get("descontoAVista"));
		}
	}

	public static Empresa newInstance() {
		return new Empresa();
	}

	@Override
	public Entity create() {
		return new Empresa();
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
