package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.macunaima.client.application.CloseDialogApplication;

public class MessageDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public MessageDialog(JFrame jFrame, String message, CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.message = message;
	}

	@Override
	public void initPane() {
		{
			JLabel lblNewLabel_1 = new JLabel("<html>" + message + "</html>");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 30));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(247, 213, 103));
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				ClientButton button = new ClientButton("OK");
				buttonPane.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				button.addActionListener(getCloseDialogActionListener());
			}
		}

	}

}
