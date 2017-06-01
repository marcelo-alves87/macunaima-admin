package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.macunaima.application.Display;

public class EntityTabPanel extends DefaultTabPanel implements Display {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityTabPanel(String name, String newEmpresaName, String newEmpresaIconPath) {
		super(name);

		// headers for the table
		String[] columns = new String[] { "Id", "Name", "Hourly Rate", "Part Time" };

		// actual data for the table in a 2d array
		Object[][] data = new Object[][] { { 1, "John", 40.0, false }, { 2, "Rambo", 70.0, false },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 42, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true }, { 3, "Zorro", 60.0, true },
				{ 40, "Zorro", 60.0, true }, };

		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.CENTER);
		panel_7.setBorder(new EmptyBorder(30, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setToolTipText("Pesquisar");
		panel_8.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.add(panel_8);

		JTextField textField = new JTextField();
		textField.setToolTipText("Pesquisar");
		panel_8.add(textField);
		textField.setColumns(30);

		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("Pesquisar");
		btnNewButton_4
				.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\search-loop-12.png"));
		panel_8.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText(newEmpresaName);
		btnNewButton_3.setIcon(new ImageIcon(newEmpresaIconPath));
		panel_7.add(btnNewButton_3);

		JPanel panel_9 = new JPanel();
		add(panel_9, BorderLayout.SOUTH);
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		// create table with data
		JTable table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_9.add(scrollPane);

	}

	@Override
	public Component getContent() {
		return this;
	}

}
