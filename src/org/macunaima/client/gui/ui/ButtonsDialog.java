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

public class ButtonsDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descontoCredito;
	private String descontoAVista;
	private org.macunaima.client.gui.event.ActionListener descontoCreditoActionListener;
	private org.macunaima.client.gui.event.ActionListener descontoAVistaActionListener;

	public ButtonsDialog(JFrame jFrame, String descontoCredito, String descontoAVista,
			org.macunaima.client.gui.event.ActionListener descontoCreditoActionListener,
			org.macunaima.client.gui.event.ActionListener descontoAVistaActionListener) {
		super(jFrame);
		this.descontoCredito = descontoCredito;
		this.descontoAVista = descontoAVista;
		this.descontoCreditoActionListener = descontoCreditoActionListener;
		this.descontoAVistaActionListener = descontoAVistaActionListener;

	}

	@Override
	public void initPane() {
		{
			JLabel lblNewLabel_1 = new JLabel("<html>Por favor, selecione uma forma de desconto</html>");
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
				ClientButton creditoButton = new ClientButton("Cartão de Crédito " + descontoCredito + "%");
				buttonPane.add(creditoButton);
				creditoButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						descontoCreditoActionListener.actionPerformed();
					}
				});
			}
			{
				ClientButton aVistaButton = new ClientButton("À Vista " + descontoAVista + "%");
				aVistaButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						descontoAVistaActionListener.actionPerformed();

					}
				});
				buttonPane.add(aVistaButton);
			}
		}

	}

}
