package org.macunaima.gui.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.macunaima.application.FilialEditApplication.FilialEditDisplay;
import org.macunaima.domain.Filial;

public class FilialEditTabPanel extends AbstractEditTabPanel<Filial> implements FilialEditDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nomeTextField;

	public FilialEditTabPanel(String name) {
		super(name);

		JPanel centerPanel = getCenterPanel();

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout(0, 0));
		centerPanel.add(north, BorderLayout.NORTH);

		JPanel panel_13 = new JPanel();
		north.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Nome");
		panel_13.add(lblNewLabel_2);

		nomeTextField = new JTextField();
		nomeTextField.setDocument(new JTextFieldLimit(100));
		panel_13.add(nomeTextField);
		nomeTextField.setColumns(40);

	}

	@Override
	protected String getConfirmDeleteMessage() {
		return "Você gostaria de remover essa filial?";
	}

	@Override
	public void copyFrom(Filial entity) {
		if (entity != null) {
			nomeTextField.setText(entity.getNome());
		}

	}

	@Override
	public void copyTo(Filial entity) {
		entity.setNome(nomeTextField.getText());
	}

	@Override
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

}
