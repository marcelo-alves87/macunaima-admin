package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;
import org.macunaima.service.DefaultService;

public class FilialEditApplication extends AbstractEditApplication<Filial> {

	public interface FilialEditDisplay extends EditDisplay<Filial> {

		JTextField getNomeTextField();

	}

	public FilialEditApplication(Filial filial) {
		super(filial);
	}

	@Override
	protected boolean validate() {
		boolean isValid = true;
		Filial filial = importFromDisplay();
		if (filial.getNome() == null || filial.getNome().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um nome da filial");
		}
		return isValid;
	}

	@Override
	protected void bind() {
		super.bind();

		FilialEditDisplay FilialEditDisplay = (FilialEditDisplay) getDisplay();

		FilialEditDisplay.getNomeTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				persist();

			}
		});

	}

	@Override
	protected Class<Filial> getInstance() {
		return Filial.class;
	}

	@Override
	protected Controller<Filial> getController() {
		return DefaultService.getFilialController();
	}

	@Override
	protected String getSucessPersistMessage() {
		return "Filial salva com sucesso!";
	}

	@Override
	protected String getSucessDeleteMessage() {
		return "Filial removida com sucesso!";
	}

	@Override
	protected String getErrorDeleteMessage() {
		return "Não foi possível remover essa filial";
	}

	@Override
	protected void close() {
		getEventListener().closeEditFilial();
	}

}
