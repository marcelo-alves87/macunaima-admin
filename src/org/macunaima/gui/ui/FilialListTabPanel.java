package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.macunaima.domain.Filial;

public class FilialListTabPanel extends AbstractListTabPanel<Filial> {

	private static final long serialVersionUID = 1L;

	public FilialListTabPanel(String newFilialName, String newFilialIconPath) {
		super(newFilialName, newFilialIconPath);
	}

	@Override
	public void put(Vector<Filial> Filials) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < Filials.size(); i++) {
			String[] data = new String[3];
			data[0] = Filials.get(i).getNome();
			data[1] = Filials.get(i).getUnidade();
			data[2] = Filials.get(i).getId();
			tableModel.addRow(data);
		}
		getJTable().setModel(tableModel);
		tableModel.fireTableDataChanged();

	}

	@Override
	protected int[] getColumnIdIndex() {
		return new int[]{2};
	}

	@Override
	protected Vector<String> getColumns() {
		Vector<String> columns = new Vector<String>();
		columns.add("Nome da Filial");
		columns.add("Unidade");
		columns.add("ID");
		return columns;
	}

}
