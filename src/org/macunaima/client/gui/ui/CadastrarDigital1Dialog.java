package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import org.macunaima.client.application.CadastrarDigital1Application;
import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.domain.Cliente;

public class CadastrarDigital1Dialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private CadastrarDigital1Application application;

	public CadastrarDigital1Dialog(JFrame jFrame, Cliente cliente,
			CadastrarDigital1Application cadastrarDigital1Application, CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.cliente = cliente;
		this.application = cadastrarDigital1Application;
	}

	@Override
	public void initPane() {
		JLabel lblNewLabel_1 = new JLabel("<html>Seja bem vindo " + (cliente.isGender() ? "Sr. " : "Srta. ")
				+ cliente.getNome()
				+ ". Para continuar, por favor conclua seu cadastro inserindo uma digital de acesso.</html>");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		contentPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.setBackground(new Color(247, 213, 103));

		JPasswordField passwordField = new JPasswordField();
		passwordField.setColumns(100);
		jPanel.add(passwordField, BorderLayout.NORTH);

		contentPanel.add(jPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(247, 213, 103));
		contentPanel.add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		ClientButton button = new ClientButton("Continuar");
		buttonPane.add(button);
		button.addActionListener(application.getCadastrarDigital1ActionListener(cliente, passwordField));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}

}
