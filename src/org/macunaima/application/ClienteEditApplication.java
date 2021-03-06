package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.service.DefaultService;

public class ClienteEditApplication extends AbstractEditApplication<Cliente> {

	public interface ClienteEditDisplay extends EditDisplay<Cliente> {

		JTextField getNomeTextField();

		JTextField getNomeCompletoTextField();

		JTextField getEmailTextField();

		JPasswordField getDigital1PasswordField();

		JPasswordField getDigital2PasswordField();

		void put(Vector<Empresa> empresas);

		JTextField getDataNascimentoTextField();

		JButton getGerarCodigoLocalizadorButton();

		JTextField getCodigoLocalizadorTextField();
	}

	private static char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'Q', 'W', 'E', 'R', 'T', 'Z', 'U',
			'I', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Y', 'X', 'C', 'V', 'B', 'N', 'M' };

	public ClienteEditApplication(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected boolean validate(Cliente cliente) {
		boolean isValid = true;
		if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um nome do cliente");
		} else if (cliente.getNomeCompleto() == null || cliente.getNomeCompleto().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um nome completo do cliente");
		} else if (cliente.getDataNascimento() == null) {
			isValid = false;
			showMessage("Por favor, insira uma data de nascimento do cliente");
		} else if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um email do cliente");
		} else if (!isValidEmailAddress(cliente.getEmail())) {
			isValid = false;
			showMessage("Por favor, insira um email do cliente v�lido");
		} else if (cliente.getEmpresa() == null || cliente.getEmpresa().getId() == null) {
			isValid = false;
			showMessage("Por favor, escolha uma empresa para o cliente");
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

		clienteEditDisplay.getNomeCompletoTextField().addActionListener(new ActionListener() {

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
		clienteEditDisplay.getGerarCodigoLocalizadorButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clienteEditDisplay.getCodigoLocalizadorTextField().setText(getRandomString());

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
		return "N�o foi poss�vel remover esse cliente";
	}

	private void fetchEmpresas() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vector<Empresa> empresas = DefaultService.getEmpresaController().findAll();
					ClienteEditDisplay clienteEditDisplay = (ClienteEditDisplay) getDisplay();
					clienteEditDisplay.put(empresas);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected void fetchFirst() {
		fetchEmpresas();
	}

	@Override
	protected void close() {
		getEventListener().closeEditCliente();
	}

	@Override
	protected String getErrorPersistMessage() {
		return "N�o foi poss�vel salvar ou atualizar esse cliente";
	}

	protected String getRandomString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			stringBuilder.append(chars[new Random().nextInt(chars.length)]);
		}
		return stringBuilder.toString();

	}

}
