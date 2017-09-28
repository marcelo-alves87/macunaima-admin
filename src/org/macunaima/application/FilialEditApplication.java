package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Filial;
import org.macunaima.service.DefaultService;

public class FilialEditApplication extends AbstractEditApplication<Filial> {

	public interface FilialEditDisplay extends EditDisplay<Filial> {

		JTextField getNomeTextField();

		JButton getLogoButton();

		void showLogoFileChooser();

		JTextField getUnidadeTextField();

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
		} else if (filial.getLogotipo() == null) {
			isValid = false;
			showMessage("Por favor, insira um logotipo da filial");
		} else if (filial.getUnidade() == null) {
			isValid = false;
			showMessage("Por favor, insira a unidade da filial");
		}
		return isValid;
	}

	@Override
	protected void bind() {
		super.bind();

		FilialEditDisplay filialEditDisplay = (FilialEditDisplay) getDisplay();

		filialEditDisplay.getNomeTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				persist();

			}
		});

		filialEditDisplay.getLogoButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				filialEditDisplay.showLogoFileChooser();

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

	@Override
	protected String getErrorPersistMessage() {
		return "Não foi possível salvar ou atualizar essa filial";
	}

}
