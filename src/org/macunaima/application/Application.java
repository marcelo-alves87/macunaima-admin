package org.macunaima.application;

public interface Application {

	public static Application getHomeApplication() {
		return new HomeApplication();
	}
	
	public static Application getEmpresasApplication() {
		return new EmpresasApplication();
	}

	Display getDisplay();

	void setDisplay(Display display);

}
