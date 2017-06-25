package org.macunaima.controller.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.macunaima.controller.ClienteController;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ClienteControllerImp extends ControllerImp<Cliente> implements ClienteController {

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("clientes");
	}

	@Override
	protected Class<Cliente> getClazz() {
		return Cliente.class;
	}

	@Override
	public Vector<Cliente> find(String search) {
		Vector<Cliente> clientes = findClientes(search);
		findEmpresas(clientes, search);
		return clientes;
	}

	private void findEmpresas(Vector<Cliente> clientes, String search) {
		DBCursor dbCursor = findDBCursor(getCollection("empresas"), "nome", search);
		List<String> empresasID = new ArrayList<String>();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Empresa empresa = new Empresa();
			empresa.fromEntity(dbObject);
			empresasID.add(empresa.getId());
		}
		if (!empresasID.isEmpty()) {
			dbCursor = findDBCursor(getCollection("clientes"), "empresaID", empresasID);
			while (dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				Cliente cliente = new Cliente();
				cliente.fromEntity(dbObject);
				if (!clientes.contains(cliente)) {
					updateEmpresa(cliente);
					clientes.add(cliente);
				}
			}
		}

	}

	private Vector<Cliente> findClientes(String search) {
		Vector<Cliente> clientes = super.find(search);
		for (Cliente cliente : clientes) {
			updateEmpresa(cliente);
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

	@Override
	protected String[] getDefaultParameters() {
		return new String[] { "nome" };
	}

	@Override
	public Cliente findDigital(String input) {
		checkConnection();

		BasicDBList basicDBList = new BasicDBList();
		basicDBList.add(new BasicDBObject("digital1", input));
		basicDBList.add(new BasicDBObject("digital2", input));
		BasicDBObject whereQuery = new BasicDBObject("$or", basicDBList);

		DBObject dbObject = getDefaultCollection().findOne(whereQuery);
		Cliente cliente = null;
		if (dbObject != null) {
			cliente = new Cliente();
			cliente.fromEntity(dbObject);
			updateEmpresa(cliente);
		}
		return cliente;
	}

}
