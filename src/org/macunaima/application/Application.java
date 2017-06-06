package org.macunaima.application;

import org.macunaima.domain.Empresa;
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

	Display getDisplay();

	void setDisplay(Display display);
	
	void setEventListener(EventListener eventListener);

}
