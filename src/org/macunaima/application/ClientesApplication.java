package org.macunaima.application;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.service.DefaultService;

public class ClientesApplication extends AbstractListApplication<Cliente> {

	protected Cliente convertToCliente(int row) {
		Cliente cliente = new Cliente();
		cliente.setId((String) getListDisplay().getJTable().getModel().getValueAt(row, 2));
		Empresa empresa = new Empresa();
		empresa.setId((String) getListDisplay().getJTable().getModel().getValueAt(row, 3));
		cliente.setEmpresa(empresa);
		return cliente;
	}

	@Override
	protected void goToEntity(int row) {
		Cliente cliente = convertToCliente(row);
		getEventListener().goToEditCliente(cliente);
	}

	@Override
	protected void goToNewEntity() {
		getEventListener().goToEditCliente(null);
	}

	@Override
	protected Controller<Cliente> getController() {
		return DefaultService.getClienteController();
	}

}
