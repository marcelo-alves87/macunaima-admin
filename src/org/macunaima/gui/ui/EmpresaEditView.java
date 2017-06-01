package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class EmpresaEditView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpresaEditView() {
		super();
		setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(50, 0, 50, 0));
		panel_11.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		panel_13.add(lblNewLabel_2);

		JTextField textField_1 = new JTextField();
		panel_13.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Desconto Cr\u00E9dito (%)");
		panel_14.add(lblNewLabel_3);

		JTextField textField_2 = new JTextField();
		panel_14.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Desconto \u00E0 Vista (%)");
		panel_14.add(lblNewLabel_4);

		JTextField textField_3 = new JTextField();
		panel_14.add(textField_3);
		textField_3.setColumns(10);

		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.ORANGE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_15.add(lblEmpresa);

		JPanel panel_16 = new JPanel();
		panel_11.add(panel_16, BorderLayout.SOUTH);

		JButton btnNewButton_5 = new JButton("Salvar");
		panel_16.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Cancelar");
		panel_16.add(btnNewButton_6);
	}

}
