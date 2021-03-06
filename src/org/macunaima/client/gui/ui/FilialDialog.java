package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.client.application.Resource;
import org.macunaima.domain.Filial;

public class FilialDialog extends CustomDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Filial> filials;
	private JList<Filial> jList;

	public FilialDialog(JFrame jFrame, Vector<Filial> filials, CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.filials = filials;
	}

	@Override
	public void initPane() {
		{
			JLabel lblNewLabel_1 = new JLabel("<html>Selecione a filial desse terminal</html>");
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
			lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
			contentPanel.add(lblNewLabel_1, BorderLayout.NORTH);

			DefaultListModel<Filial> listModel = new DefaultListModel<Filial>();
			for (Filial filial : filials) {
				listModel.addElement(filial);
			}
			JScrollPane scrollPane = new JScrollPane();
			jList = new JList<Filial>(listModel);
			jList.setFont(new Font("Tahoma", Font.BOLD, 20));
			scrollPane.setViewportView(jList);
			contentPanel.add(scrollPane, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			contentPanel.add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				ClientButton button = new ClientButton("OK");
				buttonPane.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Filial filial = jList.getSelectedValue();
						Resource.setFilialId(filial);
						dispose();
					}
				});
				button.addActionListener(getCloseDialogActionListener());
			}
		}

	}

}
