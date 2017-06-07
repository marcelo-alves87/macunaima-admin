package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.EmpresaEditApplication;
import org.macunaima.domain.Empresa;

public class EntityEditTabPanel extends JPanel implements EmpresaEditApplication.EmpresaDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton salvarButton;
	private JButton deletarButton;
	private JButton cancelarButton;
	private JTextField nomeTextField;
	private IntegerInputField creditoTextField;
	private IntegerInputField vistaTextField;

	public EntityEditTabPanel() {
		super();
		setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(50, 0, 50, 0));
		panel_11.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));

		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		panel_13.add(lblNewLabel_2);

		nomeTextField = new JTextField();
		nomeTextField.setDocument(new JTextFieldLimit(30));
		panel_13.add(nomeTextField);
		nomeTextField.setColumns(40);

		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.CENTER);

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

		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.ORANGE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_15.add(lblEmpresa);

		JPanel panel_16 = new JPanel();
		panel_11.add(panel_16, BorderLayout.SOUTH);

		salvarButton = new JButton("Salvar");
		panel_16.add(salvarButton);

		deletarButton = new JButton("Deletar");
		panel_16.add(deletarButton);

		cancelarButton = new JButton("Cancelar");
		panel_16.add(cancelarButton);
	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JButton getSalvarButton() {
		return salvarButton;
	}

	@Override
	public JButton getCancelarButton() {
		return cancelarButton;
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
	public JButton getDeletarButton() {
		return deletarButton;
	}

	@Override
	public void showMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Informação", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public boolean confirmSalvarEmpresa() {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Você deseja salvar a empresa?","Alerta",JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}

	@Override
	public boolean confirmDeletarEmpresa() {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Você deseja deletar a empresa?","Alerta",JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}

}
