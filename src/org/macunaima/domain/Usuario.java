package org.macunaima.domain;

import com.mongodb.DBObject;

public class Usuario extends Entity {

	private String login;
	private String senha;
	private boolean administrador;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("login", getLogin());
		dbObject.put("senha", getSenha());
		dbObject.put("administrador", isAdministrador());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setLogin((String) dbObject.get("login"));
			setSenha((String) dbObject.get("senha"));
			setAdministrador((Boolean) dbObject.get("administrador"));
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}


}
