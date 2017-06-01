package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DefaultTabPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;

	public DefaultTabPanel(String title) {
		super();
		this.title = title;

		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel(title);
		add(lblNewLabel_1, BorderLayout.NORTH);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
	}

	public String getTitle() {
		return title;
	}

}
