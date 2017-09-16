package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.macunaima.domain.Cliente;

public class ClienteListTabPanel extends AbstractListTabPanel<Cliente> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteListTabPanel(String newEmpresaName, String newEmpresaIconPath) {
		super(newEmpresaName, newEmpresaIconPath);
	}

	@Override
	public void put(Vector<Cliente> clientes) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < clientes.size(); i++) {
			String[] data = new String[4];
			data[0] = clientes.get(i).getNome();
			data[1] = clientes.get(i).getEmpresa().getNome();
			data[2] = clientes.get(i).getId();
			data[3] = clientes.get(i).getEmpresa().getId();
			tableModel.addRow(data);
		}
		getJTable().setModel(tableModel);
		tableModel.fireTableDataChanged();

	}

	@Override
	protected int[] getColumnIdIndex() {
		return new int[]{3,2};
	}

	@Override
	protected Vector<String> getColumns() {
		Vector<String> columns = new Vector<String>();
		columns.add("Nome do Cliente");
		columns.add("Nome da Empresa");
		columns.add("Id");
		columns.add("EmpresaId");
		return columns;
	}

}
