package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.macunaima.client.application.Application.Display;

public class Content extends JPanel implements Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel;

	public Content() {
		super();

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(100, 0, 100, 0));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon2.png"));

		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 130, 0));
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Por favor, insira sua digital");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.NORTH);

		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(50, 0, 0, 0));
		panel.add(panel_2, BorderLayout.CENTER);

		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		passwordField.setColumns(100);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.requestFocus();

		showDefaultTheme();
	}

	@Override
	public JPasswordField getUserInput() {
		return passwordField;
	}

	@Override
	public int showAskMessage(String cliente, String empresa) {
		return JOptionPane.showInternalConfirmDialog(this, "Você é " + cliente + " da empresa " + empresa + "?",
				"Macunaíma", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

	@Override
	public int showOptionMessage(String descontoCredito, String descontoAVista) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clearInput() {
		passwordField.setText("");
	}

	@Override
	public void showUserNotFoundMessage() {
		JOptionPane.showInternalMessageDialog(this, "Usuário não encontrado. Por favor, tente novamente", "Macunaíma",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void setBackgroundColor(Color color) {
		setBackground(color);
		panel_1.setBackground(color);
		lblNewLabel.setBackground(color);
		panel_2.setBackground(color);
		passwordField.setBackground(color);
		panel.setBackground(color);
	}

	@Override
	public void disable() {
		passwordField.setEnabled(false);
	}

	@Override
	public void enable() {
		passwordField.setEnabled(true);
	}

	@Override
	public void focus() {
		passwordField.requestFocus();
	}

	@Override
	public void showDefaultTheme() {
		setBackgroundColor(Color.ORANGE);

	}

	@Override
	public void showDarkTheme() {
		Color color = new Color(170, 132, 0);
		setBackgroundColor(color);

	}

}
