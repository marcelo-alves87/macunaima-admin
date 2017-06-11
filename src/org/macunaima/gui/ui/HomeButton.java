package org.macunaima.gui.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HomeButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeButton(String title, String iconPath) {
		super(title);
		setIcon(new ImageIcon(iconPath));
		setHorizontalTextPosition(JButton.CENTER);
		setVerticalTextPosition(JButton.BOTTOM);
	}

}
