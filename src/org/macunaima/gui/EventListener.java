package org.macunaima.gui;

import org.macunaima.domain.Empresa;

public interface EventListener {

	void createHomePanel();
	
	void goToEmpresasPanel();
	
	void goToEditEmpresa(Empresa empresa);
	
	void closeEditEmpresa();
}
