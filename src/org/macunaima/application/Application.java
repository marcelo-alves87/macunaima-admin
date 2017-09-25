package org.macunaima.application;

import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Usuario;
import org.macunaima.gui.EventListener;

public interface Application {

	public static Application getHomeApplication() {
		return new HomeApplication();
	}

	public static Application getEmpresasApplication() {
		return new EmpresasApplication();
	}

	public static Application getEmpresaApplication(Empresa empresa) {
		return new EmpresaEditApplication(empresa);
	}

	public static Application getClientesApplication() {
		return new ClientesApplication();
	}

	public static Application getClienteApplication(Cliente cliente) {
		return new ClienteEditApplication(cliente);
	}

	public static Application getFiliaisApplication() {
		return new FiliaisApplication();
	}

	public static Application getFilialApplication(Filial filial) {
		return new FilialEditApplication(filial);
	}
	
	public static Application getRelatoriosApplication() {
		return new RelatoriosApplication();
	}

	public static Application getUsuarioApplication(Usuario usuario) {
		return new UsuarioEditApplication(usuario);
	}

	public static Application getUsuariosApplication() {
		return new UsuariosApplication();
	}

	public static Application getLoginApplication() {
		return new LoginApplication();
	}

	Display getDisplay();

	void setDisplay(Display display);

	void setEventListener(EventListener eventListener);


}
