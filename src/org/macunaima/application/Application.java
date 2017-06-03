package org.macunaima.application;

import org.macunaima.gui.EventListener;

public interface Application {

	public static Application getHomeApplication() {
		return new HomeApplication();
	}
	
	public static Application getEmpresasApplication() {
		return new EmpresasApplication();
	}

	Display getDisplay();

	void setDisplay(Display display);
	
	void setEventListener(EventListener eventListener);

}
