package org.macunaima.gui.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Logomarca extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Logomarca() {
		super("");
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\logo.png"));
	}

}
