package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel {

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
	private JTextField textField_1;
	private JPanel panel_3;
	private JButton btnNewButton;
	private JPanel panel_4;
	private JLabel lblSejaBemVindo;

	public LoginPanel() {
		super();

		setBorder(new EmptyBorder(100, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		lblLogin = new JLabel("Login ");
		panel_1.add(lblLogin);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		
		lblSenha = new JLabel("Senha");
		panel_2.add(lblSenha);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Entrar");
		panel_3.add(btnNewButton);
		
		panel_4 = new JPanel();
		add(panel_4, BorderLayout.NORTH);
		
		lblSejaBemVindo = new JLabel("Seja Bem Vindo!");
		panel_4.add(lblSejaBemVindo);
		lblSejaBemVindo.setForeground(new Color(153, 50, 204));
		lblSejaBemVindo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblSejaBemVindo.setHorizontalAlignment(SwingConstants.CENTER);

	}


}
