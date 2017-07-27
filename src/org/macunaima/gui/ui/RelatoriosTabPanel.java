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
import org.macunaima.domain.Filial;

public class RelatoriosTabPanel extends JPanel implements RelatoriosDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton imprimirButton;
	private JRadioButton relatorioFiliaisRadio;
	private JRadioButton relatorioFilialRadio;
	private JComboBox<Filial> filiaisCombobox;

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

		relatorioFiliaisRadio = new JRadioButton("Relat\u00F3rio de Filiais");
		centerPanel.add(relatorioFiliaisRadio, BorderLayout.NORTH);
		relatorioFiliaisRadio.setSelected(true);

		relatorioFilialRadio = new JRadioButton("Relat\u00F3rio de Filial");
		centerPanel.add(relatorioFilialRadio, BorderLayout.CENTER);

		filiaisCombobox = new JComboBox<Filial>();
		centerPanel.add(filiaisCombobox, BorderLayout.SOUTH);
		filiaisCombobox.setEnabled(false);

		ButtonGroup group = new ButtonGroup();
		group.add(relatorioFilialRadio);
		group.add(relatorioFiliaisRadio);

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
	public JRadioButton getRelatorioFiliaisRadio() {
		return relatorioFiliaisRadio;
	}

	@Override
	public JRadioButton getRelatorioFilialRadio() {
		return relatorioFilialRadio;
	}

	@Override
	public void put(Vector<Filial> filiais) {
		filiaisCombobox.removeAll();
		if (filiais != null) {
			for (Filial filial : filiais) {
				filiaisCombobox.addItem(filial);
			}
		}

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

}
