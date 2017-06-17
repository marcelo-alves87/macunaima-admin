package org.macunaima.controller.imp;

import java.util.Vector;

import org.macunaima.controller.ClienteController;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class ClienteControllerImp extends ControllerImp<Cliente> implements ClienteController {

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("clientes");
	}

	@Override
	protected Class<Cliente> getInstance() {
		return Cliente.class;
	}

	@Override
	public Vector<Cliente> find(String... search) {
		Vector<Cliente> clientes = super.find(search);
		if (clientes != null) {
			for (Cliente cliente : clientes) {
				updateEmpresa(cliente);
			}
		}
		return clientes;
	}

	private void updateEmpresa(Cliente cliente) {
		DBObject dbObject = findById(cliente.getEmpresa().getId(), "empresas");
		Empresa empresa = new Empresa();
		empresa.fromEntity(dbObject);
		cliente.setEmpresa(empresa);
	}

	@Override
	public Cliente findById(String id) {
		Cliente cliente = super.findById(id);
		updateEmpresa(cliente);
		return cliente;
	}

}
