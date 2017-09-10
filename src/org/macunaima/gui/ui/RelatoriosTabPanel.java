package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.RelatoriosApplication.RelatoriosDisplay;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;

public class RelatoriosTabPanel extends JPanel implements RelatoriosDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton imprimirButton;
	private JRadioButton relatorioFilialRadio;
	private JRadioButton relatorioEmpresaRadio;
	private JComboBox<Filial> filiaisCombobox;
	private JDateTextField dataInicialTextField;
	private JDateTextField dataFinalTextField;
	private JComboBox<Empresa> empresasCombobox;

	public RelatoriosTabPanel() {
		super();
		setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel("Relat\u00F3rios");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setForeground(Color.ORANGE);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_15.add(lblEmpresa);
		JPanel centerPanel = new JPanel();
		panel_11.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBorder(new EmptyBorder(50, 100, 50, 100));
		centerPanel.setLayout(new BorderLayout(0, 0));

		ButtonGroup group = new ButtonGroup();

		JPanel panel = new JPanel();
		centerPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("Data Inicial");
		panel_3.add(lblNewLabel_1);

		dataInicialTextField = new JDateTextField();
		dataInicialTextField.setDate(JDateTextField.JDATETEXTFIELD_FIRST_DAY_MONTH);
		panel_3.add(dataInicialTextField);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.SOUTH);

		JLabel lblNewLabel_2 = new JLabel("Data Final");
		panel_4.add(lblNewLabel_2);

		dataFinalTextField = new JDateTextField();
		dataFinalTextField.setDate(JDateTextField.JDATETEXTFIELD_LAST_DAY_MONTH);
		panel_4.add(dataFinalTextField);

		JPanel panel_1 = new JPanel();
		centerPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.NORTH);

		relatorioFilialRadio = new JRadioButton("Relat\u00F3rio de Filial");
		panel_5.add(relatorioFilialRadio);
		relatorioFilialRadio.setSelected(true);
		group.add(relatorioFilialRadio);

		relatorioEmpresaRadio = new JRadioButton("Relat\u00F3rio de Empresa");
		panel_5.add(relatorioEmpresaRadio);
		group.add(relatorioEmpresaRadio);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.SOUTH);

		filiaisCombobox = new JComboBox<Filial>();
		panel_6.add(filiaisCombobox);

		empresasCombobox = new JComboBox<Empresa>();
		panel_6.add(empresasCombobox);
		empresasCombobox.setVisible(false);

		JPanel panel_2 = new JPanel();
		centerPanel.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Par\u00E2metros do Rel\u00E1torio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.GRAY);

		JPanel panel_16 = new JPanel();
		add(panel_16, BorderLayout.CENTER);

		imprimirButton = new JButton("Imprimir");
		panel_16.add(imprimirButton);
	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JButton getImprimirButton() {
		return imprimirButton;
	}

	@Override
	public JRadioButton getRelatorioFilialRadio() {
		return relatorioFilialRadio;
	}

	@Override
	public Filial getFilialSelected() {
		return (Filial) filiaisCombobox.getSelectedItem();
	}

	@Override
	public JComboBox<Filial> getFilaisCombobox() {
		return filiaisCombobox;
	}

	@Override
	public void open(String file) {
		File myFile = new File(file);
		try {
			Desktop.getDesktop().open(myFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public JRadioButton getRelatorioEmpresaRadio() {
		return relatorioEmpresaRadio;
	}

	@Override
	public void putFiliais(Vector<Filial> filiais) {
		filiaisCombobox.removeAll();
		if (filiais != null) {
			for (Filial filial : filiais) {
				filiaisCombobox.addItem(filial);
			}
		}
	}

	@Override
	public void putEmpresas(Vector<Empresa> empresas) {
		empresasCombobox.removeAll();
		if (empresas != null) {
			for (Empresa empresa : empresas) {
				empresasCombobox.addItem(empresa);
			}
		}
	}

	@Override
	public Empresa getEmpresaSelected() {
		return (Empresa) empresasCombobox.getSelectedItem();
	}

	@Override
	public JComboBox<Empresa> getEmpresasCombobox() {
		return empresasCombobox;
	}

	@Override
	public JDateTextField getDataInicialTextField() {
		return dataInicialTextField;
	}

	@Override
	public JDateTextField getDataFinalTextField() {
		return dataFinalTextField;
	}

}
