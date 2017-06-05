package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import org.macunaima.application.EmpresasApplication.EmpresasDisplay;
import org.macunaima.domain.Empresa;

public class EntityTabPanel extends JPanel implements EmpresasDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton searchButton;
	private JTextField searchText;
	private Vector<Empresa> data;
	private JTable table;

	public EntityTabPanel(String name, String newEmpresaName, String newEmpresaIconPath) {
		// headers for the table
		Vector<String> columns = new Vector<String>();
		columns.add("Nome da Empresa");
		columns.add("Desconto a Crédito");
		columns.add("Desconto à vista");

		// actual data for the table in a 2d array
		data = new Vector<Empresa>();
		setLayout(new BorderLayout());
		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.CENTER);
		panel_7.setBorder(new EmptyBorder(30, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setToolTipText("Pesquisar");
		panel_8.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.add(panel_8);

		searchText = new JTextField();
		searchText.setToolTipText("Pesquisar");
		panel_8.add(searchText);
		searchText.setColumns(30);

		searchButton = new JButton("");
		searchButton.setToolTipText("Pesquisar");
		searchButton.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\search-loop-12.png"));
		panel_8.add(searchButton);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText(newEmpresaName);
		btnNewButton_3.setIcon(new ImageIcon(newEmpresaIconPath));
		panel_7.add(btnNewButton_3);

		JPanel panel_9 = new JPanel();
		add(panel_9, BorderLayout.SOUTH);
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		// create table with data
		table = new JTable(data, columns);
		JScrollPane scrollPane = new JScrollPane(table);
		panel_9.add(scrollPane);

	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JButton getSearchButton() {
		return searchButton;
	}

	@Override
	public String getSearchText() {
		return searchText.getText();
	}

	@Override
	public void put(Vector<Empresa> empresas) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < empresas.size(); i++) {
			String[] data = new String[3];
			data[0] = empresas.get(i).getNome();
			data[1] = empresas.get(i).getDescontoCredito();
			data[2] = empresas.get(i).getDescontoAVista();
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

}
