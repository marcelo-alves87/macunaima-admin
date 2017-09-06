package org.macunaima.application;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Filial;
import org.macunaima.service.DefaultService;

public class FiliaisApplication extends AbstractListApplication<Filial> {

	protected Filial convertToFilial(int row) {
		Filial filial = new Filial();
		filial.setNome((String) getListDisplay().getJTable().getModel().getValueAt(row, 0));
		filial.setId((String) getListDisplay().getJTable().getModel().getValueAt(row, 2));
		return filial;
	}

	@Override
	protected void goToEntity(int row) {
		Filial Filial = convertToFilial(row);
		getEventListener().goToEditFilial(Filial);
	}

	@Override
	protected void goToNewEntity() {
		getEventListener().goToEditFilial(null);

	}

	@Override
	protected Controller<Filial> getController() {
		return DefaultService.getFilialController();
	}

}
