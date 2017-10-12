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
		setBackground(Color.BLACK);
		setForeground(Color.WHITE);
		setFocusPainted(false);
		setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
	}

}
