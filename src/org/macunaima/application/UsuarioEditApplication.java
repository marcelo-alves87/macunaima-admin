package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Usuario;
import org.macunaima.service.DefaultService;

public class UsuarioEditApplication extends AbstractEditApplication<Usuario> {

	public interface UsuarioEditDisplay extends EditDisplay<Usuario> {

		JTextField getLoginTextField();

		JPasswordField getSenhaPasswordField();

		JCheckBox getAdministradorCheckBox();

	}

	public UsuarioEditApplication(Usuario usuario) {
		super(usuario);
	}

	@Override
	protected boolean validate() {
		boolean isValid = true;
		Usuario usuario = importFromDisplay();
		if (usuario.getLogin() == null || usuario.getLogin().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira um login do usuário");
		} else if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
			isValid = false;
			showMessage("Por favor, insira uma senha do usuário");
		}
		return isValid;
	}

	@Override
	protected void bind() {
		super.bind();

		UsuarioEditDisplay usuarioEditDisplay = (UsuarioEditDisplay) getDisplay();

		usuarioEditDisplay.getLoginTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				persist();

			}
		});

		usuarioEditDisplay.getSenhaPasswordField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				persist();

			}
		});

	}

	@Override
	protected Class<Usuario> getInstance() {
		return Usuario.class;
	}

	@Override
	protected Controller<Usuario> getController() {
		return DefaultService.getUsuarioController();
	}

	@Override
	protected String getSucessPersistMessage() {
		return "Usuário salvo com sucesso!";
	}

	@Override
	protected String getSucessDeleteMessage() {
		return "Usuário removido com sucesso!";
	}

	@Override
	protected String getErrorDeleteMessage() {
		return "Não foi possível remover esse usuário";
	}

	@Override
	protected void close() {
		getEventListener().closeEditUsuario();
	}

	@Override
	protected String getErrorPersistMessage() {
		return "Não foi possível salvar ou atualizar esse usuário";
	}

}
