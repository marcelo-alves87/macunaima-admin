package org.macunaima.controller.imp;

import org.macunaima.controller.ClienteController;
import org.macunaima.domain.Cliente;

import com.mongodb.DBCollection;

public class ClienteControllerImp extends ControllerImp<Cliente> implements ClienteController {

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("clientes");
	}

	@Override
	protected Class<Cliente> getInstance() {
		return Cliente.class;
	}

}
