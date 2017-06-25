package org.macunaima.service;

import org.macunaima.controller.ClienteController;
import org.macunaima.controller.EmpresaController;
import org.macunaima.controller.FilialController;
import org.macunaima.controller.RegistroController;
import org.macunaima.controller.imp.ClienteControllerImp;
import org.macunaima.controller.imp.EmpresaControllerImp;
import org.macunaima.controller.imp.FilialControllerImp;
import org.macunaima.controller.imp.RegistroControllerImp;

public class DefaultService {
	private static EmpresaController empresaController;
	private static ClienteController clienteController;
	private static FilialController filialController;
	private static RegistroController registroController;

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

	public static RegistroController getRegistroController() {
		if (registroController == null) {
			registroController = new RegistroControllerImp();
		}
		return registroController;
	}
}
