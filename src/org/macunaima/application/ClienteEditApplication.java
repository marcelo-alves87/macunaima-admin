package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.service.DefaultService;

public class ClienteEditApplication extends AbstractEditApplication<Cliente> {

	public interface ClienteEditDisplay extends EditDisplay<Cliente> {

		JTextField getNomeTextField();

		JTextField getEmailTextField();

		JPasswordField getDigital1PasswordField();

		JPasswordField getDigital2PasswordField();

		void put(Vector<Empresa> empresas);

	}

	public ClienteEditApplication(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected boolean validate() {
		boolean isValid = true;
		Cliente cliente = importFromDisplay();
		if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um nome do cliente");
		} else if (cliente.getEmail() == null || cliente.getNome().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um email do cliente");
		} else if (cliente.getEmpresa() == null || cliente.getEmpresa().getId() == null) {
			isValid = false;
			showMessage("Por favor, escolha uma empresa para o cliente");
		} else if (!isValidEmailAddress(cliente.getEmail())) {
			isValid = false;
			showMessage("Por favor, insira um email do cliente válido");
		}
		return isValid;
	}

	private boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	@Override
	protected void bind() {
		super.bind();

		ClienteEditDisplay clienteEditDisplay = (ClienteEditDisplay) getDisplay();

		clienteEditDisplay.getNomeTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				persist();

			}
		});

		clienteEditDisplay.getEmailTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				persist();

			}
		});

		clienteEditDisplay.getDigital1PasswordField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});

		clienteEditDisplay.getDigital2PasswordField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});

	}

	@Override
	protected Class<Cliente> getInstance() {
		return Cliente.class;
	}

	@Override
	protected Controller<Cliente> getController() {
		return DefaultService.getClienteController();
	}

	@Override
	protected String getSucessPersistMessage() {
		return "Cliente salvo com sucesso!";
	}

	@Override
	protected String getSucessDeleteMessage() {
		return "Cliente removido com sucesso!";
	}

	@Override
	protected String getErrorDeleteMessage() {
		return "Não foi possível remover esse cliente";
	}

	private void fetchEmpresas() {
		Vector<Empresa> empresas = DefaultService.getEmpresaController().findAll();
		ClienteEditDisplay clienteEditDisplay = (ClienteEditDisplay) getDisplay();
		clienteEditDisplay.put(empresas);
	}

	@Override
	protected void fetchFirst() {
		fetchEmpresas();
	}

	@Override
	protected void close() {
		getEventListener().closeEditCliente();
	}

}
