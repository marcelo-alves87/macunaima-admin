package org.macunaima.domain;

import com.mongodb.DBObject;

public class Registro extends Entity {

	private Filial filial;
	private Cliente cliente;
	private boolean desconto;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		dbObject.put("filialID", filial.getId());
		dbObject.put("clienteID", cliente.getId());
		dbObject.put("desconto", isDesconto());
		dbObject.put("filialName", filial.getNome());
		dbObject.put("clienteName", cliente.getNome());
		dbObject.put("clienteNomeCompleto", cliente.getNomeCompleto());
		dbObject.put("empresaName", cliente.getEmpresa().getNome());
		dbObject.put("clienteUtilizacoes", cliente.getUtilizacoes());
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			Filial filial = new Filial();
			filial.setId((String) dbObject.get("filialID"));
			Cliente cliente = new Cliente();
			cliente.setId((String) dbObject.get("clienteID"));
			setDesconto((boolean) dbObject.get("desconto"));
		}

	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isDesconto() {
		return desconto;
	}

	public void setDesconto(boolean desconto) {
		this.desconto = desconto;
	}

}
