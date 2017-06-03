package org.macunaima.gui.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.macunaima.application.TabbedPaneApplication;

public class DefaultTabPanel extends JPanel implements TabbedPaneApplication.Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private JButton btnClose;
	private JTabbedPane tabbedPane;

	public DefaultTabPanel(String title, JTabbedPane tabbedPane, boolean withCloseButtton) {
		super();
		this.title = title;
		this.tabbedPane = tabbedPane;
		setLayout(new GridBagLayout());
		setOpaque(false);
		JLabel lblTitle = new JLabel(title);
		btnClose = new JButton("x");
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setFocusPainted(false);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		if (withCloseButtton) {
			add(btnClose, gbc);
		}
	}

	public String getTitle() {
		return title;
	}

	@Override
	public JButton getCloseButton() {
		return btnClose;
	}

	@Override
	public void close(Component component) {
		tabbedPane.remove(component);
		
	}

}
