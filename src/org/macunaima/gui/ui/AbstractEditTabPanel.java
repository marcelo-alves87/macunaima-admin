package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.AbstractEditApplication.EditDisplay;
import org.macunaima.domain.Entity;

public abstract class AbstractEditTabPanel<T extends Entity> extends JPanel implements EditDisplay<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton salvarButton;
	private JButton deletarButton;
	private JPanel centerPanel;

	public AbstractEditTabPanel(String name) {
		super();
		setLayout(new BorderLayout(0, 0));

		JPanel panel_11 = new JPanel();
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		centerPanel = new JPanel();
		scrollPane.setViewportView(centerPanel);
		centerPanel.setBorder(new EmptyBorder(50, 0, 50, 0));
		panel_11.add(scrollPane, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_15 = new JPanel();
		panel_11.add(panel_15, BorderLayout.NORTH);

		JLabel lblEmpresa = new JLabel(name);
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
	public JButton getDeletarButton() {
		return deletarButton;
	}

	@Override
	public void showMessage(String string) {
		JOptionPane.showMessageDialog(null, string, "Informação", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public boolean confirmDeletar() {
		int dialogResult = JOptionPane.showConfirmDialog(null, getConfirmDeleteMessage(), "Alerta",
				JOptionPane.YES_NO_OPTION);
		return dialogResult == JOptionPane.YES_OPTION;
	}

	protected abstract String getConfirmDeleteMessage();
	
	protected JPanel getCenterPanel() {
		return this.centerPanel;
	}

}
