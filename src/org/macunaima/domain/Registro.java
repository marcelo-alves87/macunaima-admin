package org.macunaima.domain;

import com.mongodb.DBObject;

public class Registro extends Entity {

	private Filial filial;
	private Cliente cliente;
	private boolean desconto;

	@Override
	public void to(DBObject dbObject) {
		super.put(dbObject);
		if (filial != null)
			dbObject.put("filialID", filial.getId());
		if (cliente != null)
			dbObject.put("clienteID", cliente.getId());
		dbObject.put("desconto", isDesconto());
		if (filial != null && filial.getNome() != null)
			dbObject.put("filialName", filial.getNome());
		if (cliente != null && cliente.getNome() != null)
			dbObject.put("clienteName", cliente.getNome());
		if (cliente != null && cliente.getNomeCompleto() != null)
			dbObject.put("clienteNomeCompleto", cliente.getNomeCompleto());
		if (cliente != null && cliente.getEmpresa() != null && cliente.getEmpresa().getNome() != null)
			dbObject.put("empresaName", cliente.getEmpresa().getNome());
		if (cliente.getEmpresa() != null && cliente.getEmpresa().getId() != null)
			dbObject.put("empresaID", cliente.getEmpresa().getId());
		if (cliente != null)
			dbObject.put("clienteUtilizacoes", cliente.getUtilizacoes());
		if (filial != null && filial.getUnidade() != null)
			dbObject.put("unidade", filial.getUnidade());
		if (cliente != null && cliente.getEmpresa() != null) {
			if (!isDesconto()) {
				dbObject.put("valor", cliente.getEmpresa().getDescontoCredito());
			} else {
				dbObject.put("valor", cliente.getEmpresa().getDescontoAVista());
			}
		}
	}

	@Override
	public void fromEntity(DBObject dbObject) {
		super.get(dbObject);
		if (dbObject != null) {
			Filial filial = new Filial();
			filial.setId((String) dbObject.get("filialID"));
			if (dbObject.containsField("filialName"))
				filial.setNome((String) dbObject.get("filialName"));
			if (dbObject.containsField("unidade"))
				filial.setUnidade((String) dbObject.get("unidade"));
			setFilial(filial);
			Cliente cliente = new Cliente();
			cliente.setId((String) dbObject.get("clienteID"));
			setCliente(cliente);
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
