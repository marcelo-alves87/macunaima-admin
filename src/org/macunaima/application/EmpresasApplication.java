package org.macunaima.application;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Empresa;
import org.macunaima.service.DefaultService;

public class EmpresasApplication extends AbstractListApplication<Empresa> {

	protected Empresa convertToEmpresa(int row) {
		Empresa empresa = new Empresa();
		empresa.setId((String) getListDisplay().getJTable().getModel().getValueAt(row, 3));
		return empresa;
	}

	@Override
	protected void goToEntity(int row) {
		Empresa empresa = convertToEmpresa(row);
		getEventListener().goToEditEmpresa(empresa);
	}

	@Override
	protected void goToNewEntity() {
		getEventListener().goToEditEmpresa(null);

	}

	@Override
	protected Controller<Empresa> getController() {
		return DefaultService.getEmpresaController();
	}

}
