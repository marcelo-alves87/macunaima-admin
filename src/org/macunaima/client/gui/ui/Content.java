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

	public Content() {
		super();

		setBackground(Color.ORANGE);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(100, 0, 100, 0));
		panel_1.setBackground(Color.ORANGE);
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon2.png"));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 130, 0));
		add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Por favor, insira sua digital");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(50, 0, 0, 0));
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2, BorderLayout.CENTER);

		passwordField = new JPasswordField();
		panel_2.add(passwordField);
		passwordField.setColumns(100);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.ORANGE);
		passwordField.requestFocus();
	}

	@Override
	public JPasswordField getUserInput() {
		return passwordField;
	}

	@Override
	public void showAskMessage(String string) {
		System.out.println(this.getParent().getClass());
	}

}
