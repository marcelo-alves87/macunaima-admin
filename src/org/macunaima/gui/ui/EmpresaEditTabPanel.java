package org.macunaima.gui.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.macunaima.application.EmpresaEditApplication.EmpresaEditDisplay;
import org.macunaima.domain.Empresa;

public class EmpresaEditTabPanel extends AbstractEditTabPanel<Empresa> implements EmpresaEditDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nomeTextField;
	private IntegerInputField creditoTextField;
	private IntegerInputField vistaTextField;

	public EmpresaEditTabPanel(String name) {
		super(name);

		JPanel centerPanel = getCenterPanel();

		JPanel panel_13 = new JPanel();
		centerPanel.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		panel_13.add(lblNewLabel_2);

		nomeTextField = new JTextField();
		nomeTextField.setDocument(new JTextFieldLimit(50));
		panel_13.add(nomeTextField);
		nomeTextField.setColumns(40);

		JPanel panel_14 = new JPanel();
		centerPanel.add(panel_14, BorderLayout.CENTER);

		JLabel lblNewLabel_3 = new JLabel("Desconto Cr\u00E9dito (%)");
		panel_14.add(lblNewLabel_3);

		creditoTextField = new IntegerInputField();
		panel_14.add(creditoTextField);
		creditoTextField.setColumns(4);

		JLabel lblNewLabel_4 = new JLabel("Desconto \u00E0 Vista (%)");
		panel_14.add(lblNewLabel_4);

		vistaTextField = new IntegerInputField();
		panel_14.add(vistaTextField);
		vistaTextField.setColumns(4);
	}

	@Override
	public void copyFrom(Empresa empresa) {
		this.nomeTextField.setText(empresa.getNome());
		this.creditoTextField.setText(empresa.getDescontoCredito());
		this.vistaTextField.setText(empresa.getDescontoAVista());
	}

	@Override
	public void copyTo(Empresa empresa) {
		empresa.setNome(nomeTextField.getText());
		empresa.setDescontoCredito(creditoTextField.getText());
		empresa.setDescontoAVista(vistaTextField.getText());
	}

	@Override
	protected String getConfirmDeleteMessage() {
		return "Você gostaria de remover essa empresa e todos os seus clientes?";
	}

	@Override
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	@Override
	public IntegerInputField getCreditoTextField() {
		return creditoTextField;
	}

	@Override
	public IntegerInputField getVistaTextField() {
		return vistaTextField;
	}

}
