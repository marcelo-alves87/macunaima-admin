package org.macunaima.application;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Empresa;
import org.macunaima.service.DefaultService;

public class EmpresaEditApplication extends AbstractEditApplication<Empresa> {

	public EmpresaEditApplication(Empresa empresa) {
		super(empresa);
	}

	@Override
	protected boolean validate() {
		boolean isValid = true;
		Empresa empresa = importFromDisplay();
		if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um nome da empresa");
		} else if (empresa.getDescontoCredito() == null || empresa.getDescontoCredito().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um valor de desconto a cr�dito");
		} else if (empresa.getDescontoAVista() == null || empresa.getDescontoAVista().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um valor de desconto � vista");
		}
		return isValid;
	}

	@Override
	protected Class<Empresa> getInstance() {
		return Empresa.class;
	}

	@Override
	protected Controller<Empresa> getController() {
		return DefaultService.getEmpresaController();
	}

	@Override
	protected String getSucessPersistMessage() {
		return "Empresa salva com sucesso!";
	}

	@Override
	protected String getSucessDeleteMessage() {
		return "Empresa removida com sucesso!";
	}

	@Override
	protected String getErrorDeleteMessage() {
		return "N�o foi poss�vel remover a empresa";
	}

}
