package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.macunaima.domain.Usuario;

public class UsuarioListTabPanel extends AbstractListTabPanel<Usuario> {

	private static final long serialVersionUID = 1L;

	public UsuarioListTabPanel(String newUsuarioName, String newUsuarioIconPath) {
		super(newUsuarioName, newUsuarioIconPath);
	}

	@Override
	public void put(Vector<Usuario> usuarios) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < usuarios.size(); i++) {
			String[] data = new String[2];
			data[0] = usuarios.get(i).getLogin();
			data[1] = usuarios.get(i).getId();
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
		columns.add("Login");
		columns.add("ID");
		return columns;
	}

}
