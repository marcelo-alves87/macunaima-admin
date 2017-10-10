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

import org.macunaima.client.application.CadastrarDigital2Application;
import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.domain.Cliente;

public class CadastrarDigital2Dialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private CadastrarDigital2Application application;

	public CadastrarDigital2Dialog(JFrame jFrame, Cliente cliente,
			CadastrarDigital2Application cadastrarDigital2Application, CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.cliente = cliente;
		this.application = cadastrarDigital2Application;
	}

	@Override
	public void initPane() {
		JLabel lblNewLabel_1 = new JLabel(
				"<html>Deseja cadastrar uma outra digital? Se sim, insira uma outra digital.</html>");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		contentPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.setBackground(Color.ORANGE);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setColumns(100);
		jPanel.add(passwordField, BorderLayout.NORTH);

		contentPanel.add(jPanel, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.ORANGE);
		contentPanel.add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		ClientButton button = new ClientButton("Continuar");
		buttonPane.add(button);
		button.addActionListener(application.getCadastrarDigital2ActionListener(cliente, passwordField));
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
	}

}
