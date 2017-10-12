package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.macunaima.client.application.CloseDialogApplication;

public abstract class CustomDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	private CloseDialogApplication closeDialogApplication;

	/**
	 * Create the dialog.
	 * 
	 * @param empresa
	 * @param cliente
	 */
	public CustomDialog(JFrame jFrame, CloseDialogApplication closeDialogApplication) {
		super(jFrame);
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 750, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(247, 213, 103));
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(100, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension screenSize = toolkit.getScreenSize();
		final int x = (screenSize.width - getWidth()) / 2;
		final int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
		this.closeDialogApplication = closeDialogApplication;
	}

	public abstract void initPane();

	protected ActionListener getCloseDialogActionListener() {
		return this.closeDialogApplication.getCloseDialogApplication();
	}

}
