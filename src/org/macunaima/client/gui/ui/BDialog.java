package org.macunaima.client.gui.ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BDialog extends JDialog {

	private JButton okBtn = new JButton("OK");
	private JButton cancelBtn = new JButton("Cancel");
	private JLabel messageLbl = new JLabel("This is a message");

	public BDialog(JFrame frame) {
		super(frame, true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(messageLbl);
		add(okBtn);
		add(cancelBtn);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

}