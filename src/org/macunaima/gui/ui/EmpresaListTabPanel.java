package org.macunaima.gui.ui;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.macunaima.domain.Empresa;

public class EmpresaListTabPanel extends AbstractListTabPanel<Empresa> {

	private static final long serialVersionUID = 1L;

	public EmpresaListTabPanel(String newEmpresaName, String newEmpresaIconPath) {
		super(newEmpresaName, newEmpresaIconPath);
	}

	@Override
	public void put(Vector<Empresa> empresas) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < empresas.size(); i++) {
			String[] data = new String[4];
			data[0] = empresas.get(i).getNome();
			data[1] = empresas.get(i).getDescontoCredito();
			data[2] = empresas.get(i).getDescontoAVista();
			data[3] = empresas.get(i).getId();
			tableModel.addRow(data);
		}
		getJTable().setModel(tableModel);
		tableModel.fireTableDataChanged();

	}

	@Override
	protected int[] getColumnIdIndex() {
		return new int[]{3};
	}

	@Override
	protected Vector<String> getColumns() {
		Vector<String> columns = new Vector<String>();
		columns.add("Nome da Empresa");
		columns.add("Desconto a Crédito");
		columns.add("Desconto à Vista");
		columns.add("Id");
		return columns;
	}

}
