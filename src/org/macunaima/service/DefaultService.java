package org.macunaima.service;

import org.macunaima.controller.ClienteController;
import org.macunaima.controller.EmpresaController;
import org.macunaima.controller.imp.ClienteControllerImp;
import org.macunaima.controller.imp.EmpresaControllerImp;

public class DefaultService {
	private static EmpresaController empresaController;
	private static ClienteController clienteController;

	public static EmpresaController getEmpresaController() {
		if(empresaController == null) {
			empresaController = new EmpresaControllerImp();
		}
		return empresaController;
	}

	public static ClienteController getClienteController() {
		if(clienteController == null) {
			clienteController = new ClienteControllerImp();
		}
		return clienteController;
	}
}
