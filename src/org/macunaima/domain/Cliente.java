package org.macunaima.domain;

import java.util.Date;

import com.mongodb.DBObject;

public class Cliente extends Entity {

	private String nome;
	private String nomeCompleto;
	private String email;
	private boolean gender; // true male & false female
	private Empresa empresa;
	private String digital1;
	private String digital2;
	private int utilizacoes;
	private Date dataNascimento;
	private String codigoLocalizador;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("nome", getNome());
		dbObject.put("nomeCompleto", getNomeCompleto());
		dbObject.put("email", getEmail());
		dbObject.put("gender", isGender());
		if (empresa == null || (empresa != null && empresa.isNew())) {
			dbObject.put("empresaID", "");
		} else if (empresa != null && !empresa.isNew()) {
			dbObject.put("empresaID", empresa.getId());
		}
		dbObject.put("digital1", getDigital1());
		dbObject.put("digital2", getDigital2());
		dbObject.put("utilizacoes", getUtilizacoes());
		dbObject.put("dataNascimento", getDataNascimento());
		dbObject.put("codigoLocalizador", getCodigoLocalizador());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			setNome((String) dbObject.get("nome"));
			setNomeCompleto((String) dbObject.get("nomeCompleto"));
			setEmail((String) dbObject.get("email"));
			setGender((Boolean) dbObject.get("gender"));
			Empresa empresa = new Empresa();
			empresa.setId((String) dbObject.get("empresaID"));
			setEmpresa(empresa);
			setDigital1((String) dbObject.get("digital1"));
			setDigital2((String) dbObject.get("digital2"));
			if (dbObject.get("utilizacoes") != null) {
				setUtilizacoes((int) dbObject.get("utilizacoes"));
			} else {
				setUtilizacoes(0);
			}
			setDataNascimento((Date) dbObject.get("dataNascimento"));
			setCodigoLocalizador((String) dbObject.get("codigoLocalizador"));
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

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getUtilizacoes() {
		return utilizacoes;
	}

	public void setUtilizacoes(int utilizacoes) {
		this.utilizacoes = utilizacoes;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCodigoLocalizador() {
		return codigoLocalizador;
	}

	public void setCodigoLocalizador(String codigoLocalizador) {
		this.codigoLocalizador = codigoLocalizador;
	}

}
