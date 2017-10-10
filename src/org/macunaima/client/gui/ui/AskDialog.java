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

import org.macunaima.client.application.CloseDialogApplication;

public class AskDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cliente;
	private String empresa;
	private org.macunaima.client.gui.event.ActionListener actionListener;

	public AskDialog(JFrame jFrame, String cliente, String empresa,
			org.macunaima.client.gui.event.ActionListener actionListener,
			CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.cliente = cliente;
		this.empresa = empresa;
		this.actionListener = actionListener;
	}

	@Override
	public void initPane() {
		{
			JLabel lblNewLabel_1 = new JLabel("<html>Você é<br>" + cliente + "<br>da empresa " + empresa + "?</html>");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 30));
			lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				ClientButton button = new ClientButton("SIM");
				buttonPane.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						actionListener.actionPerformed();
					}
				});
			}
			{
				ClientButton noButton = new ClientButton("NÃO");
				noButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();

					}
				});
				noButton.addActionListener(getCloseDialogActionListener());
				buttonPane.add(noButton);
			}
		}

	}

}
