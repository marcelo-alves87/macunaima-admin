package org.macunaima.client.gui.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class ClientButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientButton(String title) {
		super(title);
		setBackground(new Color(170, 132, 0));
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setFont(new Font("Tahoma", Font.BOLD, 30));
	}

}
