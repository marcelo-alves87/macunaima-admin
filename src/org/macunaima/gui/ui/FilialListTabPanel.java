package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.macunaima.domain.Filial;

public class FilialListTabPanel extends AbstractListTabPanel<Filial> {

	private static final long serialVersionUID = 1L;

	public FilialListTabPanel(String name, String newFilialName, String newFilialIconPath) {
		super(name, newFilialName, newFilialIconPath);
	}

	@Override
	public void put(Vector<Filial> Filials) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < Filials.size(); i++) {
			String[] data = new String[2];
			data[0] = Filials.get(i).getNome();
			data[1] = Filials.get(i).getId();
			tableModel.addRow(data);
		}
		getJTable().setModel(tableModel);
		tableModel.fireTableDataChanged();

	}

	@Override
	protected int[] getColumnIdIndex() {
		return new int[]{1};
	}

	@Override
	protected Vector<String> getColumns() {
		Vector<String> columns = new Vector<String>();
		columns.add("Nome da Filial");
		columns.add("ID");
		return columns;
	}

}
