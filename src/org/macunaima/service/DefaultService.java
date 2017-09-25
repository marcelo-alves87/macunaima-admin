package org.macunaima.service;

import org.macunaima.controller.ClienteController;
import org.macunaima.controller.EmpresaController;
import org.macunaima.controller.FilialController;
import org.macunaima.controller.RegistroController;
import org.macunaima.controller.RelatoriosController;
import org.macunaima.controller.UsuarioController;
import org.macunaima.controller.imp.ClienteControllerImp;
import org.macunaima.controller.imp.EmpresaControllerImp;
import org.macunaima.controller.imp.FilialControllerImp;
import org.macunaima.controller.imp.RegistroControllerImp;
import org.macunaima.controller.imp.RelatoriosControllerImp;
import org.macunaima.controller.imp.UsuarioControllerImp;
import org.macunaima.domain.Usuario;

public class DefaultService {
	private static EmpresaController empresaController;
	private static ClienteController clienteController;
	private static FilialController filialController;
	private static RegistroController registroController;
	private static RelatoriosController relatoriosController;
	private static UsuarioController usuarioController;
	private static Usuario usuarioSession;

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
	
	public static RelatoriosController getRelatoriosController() {
		if (relatoriosController == null) {
			relatoriosController = new RelatoriosControllerImp();
		}
		return relatoriosController;
	}

	public static UsuarioController getUsuarioController() {
		if (usuarioController == null) {
			usuarioController = new UsuarioControllerImp();
		}
		return usuarioController;
	}

	public static Usuario getUsuarioSession() {
		return usuarioSession;
	}
	
	public static boolean hasUsuarioInSession() {
		return usuarioSession != null;
	}

	public static void setUsuarioSession(Usuario usuarioSession) {
		DefaultService.usuarioSession = usuarioSession;
	}
}
