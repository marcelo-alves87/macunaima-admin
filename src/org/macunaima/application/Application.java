package org.macunaima.application;

public interface Application {

	public static Application getDefaultHomeApplication() {
		return new HomeApplication();
	}

	Display getDisplay();

	void setDisplay(Display display);

}
