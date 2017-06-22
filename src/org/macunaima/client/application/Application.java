package org.macunaima.client.application;

import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.macunaima.client.gui.ui.EventBus;

public class Application {

	public interface Display {

		JPasswordField getUserInput();

		void showAskMessage(String string);
	}

	private Display display;
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
		if (input != null && !input.isEmpty()) {
			eventBus.showMessage("Vice");
		}
	}
}
