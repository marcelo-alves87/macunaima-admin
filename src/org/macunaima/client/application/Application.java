package org.macunaima.client.application;

import java.awt.EventQueue;

import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.macunaima.client.gui.event.ActionListener;
import org.macunaima.client.gui.event.EventBus;
import org.macunaima.domain.Cliente;
import org.macunaima.service.DefaultService;

public class Application {

	public interface Display {

		JPasswordField getUserInput();

		int showAskMessage(String cliente, String empresa);

		int showOptionMessage(String descontoCredito, String descontoAVista);

		void clearInput();

		void showUserNotFoundMessage();

		void disable();

		void enable();

		void focus();

		void showDefaultTheme();

		void showDarkTheme();

	}

	private Display display;
	private boolean isFetching;
	private EventBus eventBus;

	public Application(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public void setDisplay(Display display) {
		this.display = display;
		bind();
	}

	private void bind() {
		display.getUserInput().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				findText();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findText();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findText();

			}
		});
	}

	private void findText() {
		String input = display.getUserInput().getText();
		fetch(input);
	}

	private void fetch(String input) {
		if (!isFetching && input != null && !input.isEmpty()) {
			isFetching = true;
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Cliente cliente = DefaultService.getClienteController().findDigital(input);
						openInput(cliente);
					} catch (Exception e) {
						close();
					}
				}

			});

		}
	}

	private void openInputButtons(Cliente cliente) {
		eventBus.showMessage(cliente.getEmpresa().getDescontoCredito(), cliente.getEmpresa().getDescontoAVista(),
				new ActionListener() {

					@Override
					public void actionPerformed() {
						showSucessMessage();

					}
				}, new ActionListener() {

					@Override
					public void actionPerformed() {
						showSucessMessage();

					}
				});
	}

	protected void showSucessMessage() {
		eventBus.showMessage(
				"Seu cupom de desconto est� dispon�vel no caixa do restaurante.<br>Obrigado por usar nossos servi�os.");

	}

	private void openInput(Cliente cliente) {
		display.disable();
		display.showDarkTheme();
		if (cliente != null)
			eventBus.showMessage(cliente.getNome(), cliente.getEmpresa().getNome(), new ActionListener() {

				@Override
				public void actionPerformed() {
					openInputButtons(cliente);

				}
			});
		else
			eventBus.showMessage("Usu�rio n�o encontrado. Por favor, tente novamente.");
	}

	public void close() {
		display.enable();
		isFetching = false;
		display.clearInput();
		display.focus();
		display.showDefaultTheme();
	}
}
