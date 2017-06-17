package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Empresa;
import org.macunaima.gui.ui.IntegerInputField;
import org.macunaima.service.DefaultService;

public class EmpresaEditApplication extends AbstractEditApplication<Empresa> {
	
	public interface EmpresaEditDisplay extends EditDisplay<Empresa> {
		
		JTextField getNomeTextField();
		
		IntegerInputField getCreditoTextField();
		
		IntegerInputField getVistaTextField();

	}

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
			showMessage("Por favor, insira um valor de desconto a crédito");
		} else if (empresa.getDescontoAVista() == null || empresa.getDescontoAVista().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um valor de desconto à vista");
		}
		return isValid;
	}

	@Override
	protected void bind() {
		super.bind();
		
		EmpresaEditDisplay empresaEditDisplay = (EmpresaEditDisplay) getDisplay();
		
		empresaEditDisplay.getNomeTextField().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});
		
		empresaEditDisplay.getNomeTextField().requestFocus();
		
		empresaEditDisplay.getCreditoTextField().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});
		
		empresaEditDisplay.getVistaTextField().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});
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
		return "Não foi possível remover a empresa";
	}

}
