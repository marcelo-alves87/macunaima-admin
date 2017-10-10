package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.client.application.LocalizacaoApplication;
import org.macunaima.gui.ui.JVirtualKeyboard;

public class LocalizacaoDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalizacaoApplication localizacaoApplication;
	private JTextField jTextField;

	public LocalizacaoDialog(JFrame jFrame, LocalizacaoApplication localizacaoApplication,
			CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.localizacaoApplication = localizacaoApplication;
	}

	@Override
	public void initPane() {

		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.ORANGE);
		jPanel.setLayout(new BorderLayout());

		JLabel lblNewLabel_1 = new JLabel("<html>Por favor, digite seu código localizador</html>");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		jPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		jTextField = new JTextField(30);
		jTextField.getDocument().addDocumentListener(getLocalizadorDocumentListener());
		jTextField.setEditable(false);
		jTextField.setFont(new Font("Serif", Font.BOLD, 25));
		jPanel.add(jTextField, BorderLayout.CENTER);

		contentPanel.add(jPanel, BorderLayout.NORTH);

		contentPanel.add(new JVirtualKeyboard(jTextField), BorderLayout.CENTER);

	}

	private DocumentListener getLocalizadorDocumentListener() {
		DocumentListener documentListener = new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				processCodigoLocalizador();

			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				processCodigoLocalizador();

			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				processCodigoLocalizador();

			}
		};

		return documentListener;
	}

	private void processCodigoLocalizador() {
		if (jTextField.getText().length() >= 5) {
			dispose();
			this.localizacaoApplication.findCliente(jTextField.getText());
		}
	}

}
