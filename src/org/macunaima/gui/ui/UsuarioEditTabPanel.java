package org.macunaima.gui.ui;

import java.awt.BorderLayout;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.application.UsuarioEditApplication.UsuarioEditDisplay;
import org.macunaima.domain.Usuario;

public class UsuarioEditTabPanel extends AbstractEditTabPanel<Usuario> implements UsuarioEditDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField loginTextField;
	private JPasswordField senhaPassworldField;
	private JCheckBox administradorCheckBox;

	public UsuarioEditTabPanel(String name) {
		super(name);

		JPanel centerPanel = getCenterPanel();

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout(0, 0));
		centerPanel.add(north, BorderLayout.NORTH);

		JPanel panel_13 = new JPanel();
		north.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Login");
		panel_13.add(lblNewLabel_2);

		loginTextField = new JTextField();
		loginTextField.setDocument(new JTextFieldLimit(50));
		panel_13.add(loginTextField);
		loginTextField.setColumns(40);

		JPanel panel_15 = new JPanel();
		north.add(panel_15, BorderLayout.CENTER);

		JLabel lblNewLabel_12 = new JLabel("Senha");
		panel_15.add(lblNewLabel_12);

		senhaPassworldField = new JPasswordField();
		senhaPassworldField.setDocument(new JTextFieldLimit(50));
		panel_15.add(senhaPassworldField);
		senhaPassworldField.setColumns(40);

		JPanel panel_14 = new JPanel();
		north.add(panel_14, BorderLayout.SOUTH);

		JLabel lblNewLabel_3 = new JLabel("Administrador");
		panel_14.add(lblNewLabel_3);

		administradorCheckBox = new JCheckBox();
		panel_14.add(administradorCheckBox);

	}

	@Override
	protected String getConfirmDeleteMessage() {
		return "Você gostaria de remover esse Usuário?";
	}

	@Override
	public void copyFrom(Usuario entity) {
		if (entity != null) {
			loginTextField.setText(entity.getLogin());
			senhaPassworldField.setText(entity.getSenha());
			administradorCheckBox.setSelected(entity.isAdministrador());
		}

	}

	@Override
	public void copyTo(Usuario entity) {
		entity.setLogin(loginTextField.getText());
		entity.setSenha(senhaPassworldField.getText());
		entity.setAdministrador(administradorCheckBox.isSelected());
	}

	@Override
	public JTextField getLoginTextField() {
		return loginTextField;
	}

	@Override
	public JPasswordField getSenhaPasswordField() {
		return senhaPassworldField;
	}

	@Override
	public JCheckBox getAdministradorCheckBox() {
		return administradorCheckBox;
	}

}
