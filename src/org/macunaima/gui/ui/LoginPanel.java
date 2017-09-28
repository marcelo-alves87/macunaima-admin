package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.LoginApplication.LoginDisplay;

public class LoginPanel extends JPanel implements LoginDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblLogin;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblSenha;
	private JPasswordField textField_1;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JPanel panel_4;
	private JLabel lblAcesseSuaConta;
	private JPanel panel_5;
	private JPanel panel_6;

	public LoginPanel() {
		super();

		setBorder(new EmptyBorder(100, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);

		lblLogin = new JLabel("Login ");
		panel_1.add(lblLogin);

		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(25);

		panel_2 = new JPanel();
		panel.add(panel_2);

		panel_5 = new JPanel();
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		btnNewButton = new JButton("Entrar");
		panel_5.add(btnNewButton);

		panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);

		lblSenha = new JLabel("Senha");
		panel_6.add(lblSenha);

		textField_1 = new JPasswordField();
		panel_6.add(textField_1);
		textField_1.setColumns(25);

		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);

		panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);

		lblAcesseSuaConta = new JLabel("Acesse sua conta");
		panel_4.add(lblAcesseSuaConta);
		lblAcesseSuaConta.setForeground(Color.BLACK);
		lblAcesseSuaConta.setFont(new Font("Calibri", Font.BOLD, 15));
		lblAcesseSuaConta.setHorizontalAlignment(SwingConstants.CENTER);

	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JTextField getLoginTextField() {
		return textField;
	}

	@Override
	public JPasswordField getSenhaPasswordField() {
		return textField_1;
	}

	@Override
	public JButton getEntrarButton() {
		return btnNewButton;
	}

	@Override
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Informação", JOptionPane.INFORMATION_MESSAGE);
	}

}
