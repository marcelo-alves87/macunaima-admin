package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import org.macunaima.application.EmpresasApplication.EmpresasDisplay;
import org.macunaima.domain.Empresa;

public class EntityListTabPanel extends JPanel implements EmpresasDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton searchButton;
	private JTextField searchText;
	private Vector<Empresa> data;
	private JTable table;
	private JButton novaEmpresaButton;

	public EntityListTabPanel(String name, String newEmpresaName, String newEmpresaIconPath) {
		// headers for the table
		Vector<String> columns = new Vector<String>();
		columns.add("Nome da Empresa");
		columns.add("Desconto a Crédito");
		columns.add("Desconto à Vista");
		columns.add("Id");

		// actual data for the table in a 2d array
		data = new Vector<Empresa>();
		setLayout(new BorderLayout());
		JPanel panel_7 = new JPanel();
		add(panel_7, BorderLayout.CENTER);
		panel_7.setBorder(new EmptyBorder(10, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setToolTipText("Pesquisar");
		panel_8.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.add(panel_8);

		searchText = new JTextField();
		searchText.setToolTipText("Pesquisar");
		searchText.setDocument(new JTextFieldLimit(30));
		panel_8.add(searchText);
		searchText.setColumns(30);

		searchButton = new JButton("");
		searchButton.setToolTipText("Pesquisar");
		searchButton.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\search-loop-12.png"));
		panel_8.add(searchButton);

		novaEmpresaButton = new JButton("");
		novaEmpresaButton.setToolTipText(newEmpresaName);
		novaEmpresaButton.setIcon(new ImageIcon(newEmpresaIconPath));
		panel_7.add(novaEmpresaButton);

		JPanel panel_9 = new JPanel();
		add(panel_9, BorderLayout.SOUTH);
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		// create table with data
		table = new JTable(data, columns);
		table.setDefaultEditor(Object.class, null);
		table.removeColumn(table.getColumnModel().getColumn(3));
		JScrollPane scrollPane = new JScrollPane(table);
		panel_9.add(scrollPane);
		
		JPanel panel_15 = new JPanel();
		add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel("Empresas");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.ORANGE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_15.add(lblEmpresa);

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
			String[] data = new String[4];
			data[0] = empresas.get(i).getNome();
			data[1] = empresas.get(i).getDescontoCredito();
			data[2] = empresas.get(i).getDescontoAVista();
			data[3] = empresas.get(i).getId();
			tableModel.addRow(data);
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	@Override
	public JTable getJTable() {
		return table;
	}

	@Override
	public JButton goToNewEmpresa() {
		return novaEmpresaButton;
	}

}
