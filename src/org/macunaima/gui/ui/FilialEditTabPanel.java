package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import org.macunaima.application.FilialEditApplication.FilialEditDisplay;
import org.macunaima.domain.Filial;

public class FilialEditTabPanel extends AbstractEditTabPanel<Filial> implements FilialEditDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nomeTextField;

	private JTextField unidadeTextField;

	private JButton logoButton;

	private ImageLabel picLabel;

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
		nomeTextField.setColumns(50);

		JPanel panel_15 = new JPanel();
		north.add(panel_15, BorderLayout.CENTER);

		JLabel lblNewLabel_12 = new JLabel("Unidade");
		panel_15.add(lblNewLabel_12);

		unidadeTextField = new JTextField();
		unidadeTextField.setDocument(new JTextFieldLimit(50));
		panel_15.add(unidadeTextField);
		unidadeTextField.setColumns(40);

		JPanel panel = new JPanel();
		north.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_16 = new JPanel();
		panel.add(panel_16, BorderLayout.NORTH);

		logoButton = new JButton("Novo Logotipo");
		panel_16.add(logoButton);

		JPanel panel_17 = new JPanel();
		panel.add(panel_17);

		picLabel = new ImageLabel();
		panel_17.add(picLabel);

	}

	@Override
	protected String getConfirmDeleteMessage() {
		return "Você gostaria de remover essa filial?";
	}

	@Override
	public void copyFrom(Filial entity) {
		if (entity != null) {
			nomeTextField.setText(entity.getNome());
			picLabel.setImageFile(entity.getLogotipo());
			unidadeTextField.setText(entity.getUnidade());
		}

	}

	@Override
	public void copyTo(Filial entity) {
		entity.setNome(nomeTextField.getText());
		entity.setLogotipo(picLabel.getImageFile());
		entity.setUnidade(unidadeTextField.getText());
	}

	@Override
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	@Override
	public JButton getLogoButton() {
		return logoButton;
	}

	@Override
	public void showLogoFileChooser() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagens", "jpg", "png", "gif",
				"jpeg");
		jfc.setFileFilter(filter);

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			picLabel.setImageFile(selectedFile);
		}

	}

	@Override
	public JTextField getUnidadeTextField() {
		return unidadeTextField;
	}

}
