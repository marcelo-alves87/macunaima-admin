package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.macunaima.domain.Callback;
import org.macunaima.gui.EventListener;
import org.macunaima.service.DefaultService;

public class LoginApplication implements Application {

	public interface LoginDisplay extends Display {

		JTextField getLoginTextField();

		JPasswordField getSenhaPasswordField();

		JButton getEntrarButton();

		void showMessage(String message);

	}

	private LoginDisplay display;
	private EventListener eventListener;

	private void bind() {
		this.display.getLoginTextField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLogin();
			}
		});

		this.display.getSenhaPasswordField().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLogin();

			}
		});

		this.display.getEntrarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				validateLogin();

			}
		});

	}

	@Override
	public Display getDisplay() {
		return this.display;
	}

	@Override
	public void setDisplay(Display display) {
		this.display = (LoginDisplay) display;
		bind();
	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;

	}

	private void validateLogin() {
		if (display.getLoginTextField() == null || display.getLoginTextField().getText().isEmpty()) {
			display.showMessage("Por favor, preencha o campo login!");
		} else if (display.getSenhaPasswordField() == null || display.getSenhaPasswordField().getText().isEmpty()) {
			display.showMessage("Por favor, preencha o campo senha!");
		} else {
			validateLoginInService();
		}
	}

	private void validateLoginInService() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Callback callback = DefaultService.getUsuarioController().validateLogin(
						display.getLoginTextField().getText(), display.getSenhaPasswordField().getText());
				processCallBack(callback);
			}
		});

	}

	private void processCallBack(Callback callback) {
		//Se 1 e administrar redireciona
		//Se 1 e n adminstrador
		// Se 0 show Message
	}
}
