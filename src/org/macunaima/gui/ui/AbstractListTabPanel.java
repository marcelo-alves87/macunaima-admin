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

import org.macunaima.application.AbstractListApplication.ListDisplay;
import org.macunaima.domain.Entity;

public abstract class AbstractListTabPanel<T extends Entity> extends JPanel implements ListDisplay<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton searchButton;
	private JTextField searchText;
	private Vector<T> data;
	private JTable table;
	private JButton novaEntityButton;

	public AbstractListTabPanel(String name, String newEmpresaName, String newEmpresaIconPath) {
		// headers for the table
		Vector<String> columns = getColumns();

		// actual data for the table in a 2d array
		data = new Vector<T>();
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

		novaEntityButton = new JButton("");
		novaEntityButton.setToolTipText(newEmpresaName);
		novaEntityButton.setIcon(new ImageIcon(newEmpresaIconPath));
		panel_7.add(novaEntityButton);

		JPanel panel_9 = new JPanel();
		add(panel_9, BorderLayout.SOUTH);
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		// create table with data
		table = new JTable(data, columns);
		table.setDefaultEditor(Object.class, null);

		int[] indexes = getColumnIdIndex();
		if (indexes != null) {
			for (int i = 0; i < indexes.length; i++) {
				table.removeColumn(table.getColumnModel().getColumn(indexes[i]));
			}
		}

		JScrollPane scrollPane = new JScrollPane(table);
		panel_9.add(scrollPane);

		JPanel panel_15 = new JPanel();
		add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel(name);
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.ORANGE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_15.add(lblEmpresa);

	}

	protected abstract int[] getColumnIdIndex();

	protected abstract Vector<String> getColumns();

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JButton getSearchButton() {
		return searchButton;
	}

	@Override
	public JTable getJTable() {
		return table;
	}

	@Override
	public JTextField getSearch() {
		return searchText;
	}

	@Override
	public JButton goToNewEntity() {
		return novaEntityButton;
	}

}
