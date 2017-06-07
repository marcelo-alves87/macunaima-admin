package org.macunaima.service;

import org.macunaima.controller.EmpresaController;
import org.macunaima.controller.imp.EmpresaControllerImp;

public class DefaultService {
	private static EmpresaController empresaController;

	public static EmpresaController getEmpresaController() {
		if(empresaController == null) {
			empresaController = new EmpresaControllerImp();
		}
		return empresaController;
	}
}
