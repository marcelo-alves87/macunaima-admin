package org.macunaima.domain;

import com.mongodb.DBObject;

public class Cliente extends Entity {

	private String nome;
	private String email;
	private boolean gender; // true male & false female
	private Empresa empresa;
	private String digital1;
	private String digital2;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("nome", getNome());
		dbObject.put("email", getEmail());
		dbObject.put("gender", isGender());
		if (empresa == null || (empresa != null && empresa.isNew())) {
			dbObject.put("empresaID", "");
		} else if (empresa != null && !empresa.isNew()) {
			dbObject.put("empresaID", empresa.getId());
		}
		dbObject.put("digital1", getDigital1());
		dbObject.put("digital2", getDigital2());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setNome((String) dbObject.get("nome"));
			setEmail((String) dbObject.get("email"));
			setGender((Boolean) dbObject.get("gender"));
			Empresa empresa = new Empresa();
			empresa.setId((String) dbObject.get("empresaID"));
			setEmpresa(empresa);
			setDigital1((String) dbObject.get("digital1"));
			setDigital2((String) dbObject.get("digital2"));
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDigital1() {
		return digital1;
	}

	public void setDigital1(String digital1) {
		this.digital1 = digital1;
	}

	public String getDigital2() {
		return digital2;
	}

	public void setDigital2(String digital2) {
		this.digital2 = digital2;
	}

}
