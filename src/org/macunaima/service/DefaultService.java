package org.macunaima.service;

import org.macunaima.controller.ClienteController;
import org.macunaima.controller.EmpresaController;
import org.macunaima.controller.FilialController;
import org.macunaima.controller.imp.ClienteControllerImp;
import org.macunaima.controller.imp.EmpresaControllerImp;
import org.macunaima.controller.imp.FilialControllerImp;

public class DefaultService {
	private static EmpresaController empresaController;
	private static ClienteController clienteController;
	private static FilialController filialController;

	public static EmpresaController getEmpresaController() {
		if (empresaController == null) {
			empresaController = new EmpresaControllerImp();
		}
		return empresaController;
	}

	public static ClienteController getClienteController() {
		if (clienteController == null) {
			clienteController = new ClienteControllerImp();
		}
		return clienteController;
	}

	public static FilialController getFilialController() {
		if (filialController == null) {
			filialController = new FilialControllerImp();
		}
		return filialController;
	}
}
