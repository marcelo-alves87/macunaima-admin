package org.macunaima.gui.ui;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.macunaima.application.ClienteEditApplication.ClienteEditDisplay;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;

public class ClienteEditTabPanel extends AbstractEditTabPanel<Cliente> implements ClienteEditDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField nomeTextField;
	private JTextField nomeCompletoTextField;
	private JTextField emailTextField;
	private JRadioButton genderMaleRadio;
	private JRadioButton genderFemaleRadio;
	private JComboBox<Empresa> empresaComboBox;
	private JPasswordField digital1TextField;
	private JPasswordField digital2TextField;
	private JTextField dataNascimentoTextField;

	public ClienteEditTabPanel(String name) {
		super(name);

		JPanel centerPanel = getCenterPanel();

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout(0, 0));
		centerPanel.add(north, BorderLayout.NORTH);

		JPanel panel_13 = new JPanel();
		north.add(panel_13, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("Primeiro Nome");
		panel_13.add(lblNewLabel_2);

		nomeTextField = new JTextField();
		nomeTextField.setDocument(new JTextFieldLimit(50));
		panel_13.add(nomeTextField);
		nomeTextField.setColumns(40);

		JPanel panel_15 = new JPanel();
		north.add(panel_15, BorderLayout.CENTER);

		JLabel lblNewLabel_12 = new JLabel("Nome Completo");
		panel_15.add(lblNewLabel_12);

		nomeCompletoTextField = new JTextField();
		nomeCompletoTextField.setDocument(new JTextFieldLimit(100));
		panel_15.add(nomeCompletoTextField);
		nomeCompletoTextField.setColumns(70);

		JPanel panel_4 = new JPanel();
		north.add(panel_4, BorderLayout.SOUTH);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		panel_4.add(lblDataDeNascimento);

		dataNascimentoTextField = new JFormattedTextField(DateFormat.getDefaultFormat());
		dataNascimentoTextField.setColumns(20);
		panel_4.add(dataNascimentoTextField);

		JPanel center = new JPanel();
		centerPanel.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		center.add(panel, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Sexo");
		panel.add(lblNewLabel);

		genderMaleRadio = new JRadioButton("Masculino");
		panel.add(genderMaleRadio);

		genderFemaleRadio = new JRadioButton("Feminino");
		panel.add(genderFemaleRadio);

		genderMaleRadio.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(genderMaleRadio);
		group.add(genderFemaleRadio);

		JPanel panel_1 = new JPanel();
		center.add(panel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("Empresa");
		panel_1.add(lblNewLabel_1);

		empresaComboBox = new JComboBox<Empresa>();
		panel_1.add(empresaComboBox);

		JPanel panel_14 = new JPanel();
		center.add(panel_14, BorderLayout.NORTH);

		JLabel lblNewLabel_3 = new JLabel("Email");
		panel_14.add(lblNewLabel_3);

		emailTextField = new JTextField();
		emailTextField.setDocument(new JTextFieldLimit(100));
		panel_14.add(emailTextField);
		emailTextField.setColumns(40);

		JPanel south = new JPanel();
		getCenterPanel().add(south, BorderLayout.SOUTH);
		south.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		south.add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel("Digital 1");
		panel_2.add(lblNewLabel_4);

		digital1TextField = new JPasswordField();
		panel_2.add(digital1TextField);
		digital1TextField.setColumns(40);

		JPanel panel_3 = new JPanel();
		south.add(panel_3, BorderLayout.CENTER);

		JLabel lblNewLabel_5 = new JLabel("Digital 2");
		panel_3.add(lblNewLabel_5);

		digital2TextField = new JPasswordField();
		panel_3.add(digital2TextField);
		digital2TextField.setColumns(40);

	}

	@Override
	protected String getConfirmDeleteMessage() {
		return "Você gostaria de remover esse cliente?";
	}

	@Override
	public void copyFrom(Cliente entity) {
		if (entity != null) {
			nomeTextField.setText(entity.getNome());
			nomeCompletoTextField.setText(entity.getNomeCompleto());
			emailTextField.setText(entity.getEmail());
			genderMaleRadio.setSelected(entity.isGender());
			genderFemaleRadio.setSelected(!entity.isGender());
			setEmpresaSelected(entity.getEmpresa());
			digital1TextField.setText(entity.getDigital1());
			digital2TextField.setText(entity.getDigital2());
			dataNascimentoTextField.setText(DateFormat.format(entity.getDataNascimento()));
		}

	}

	private void setEmpresaSelected(Empresa empresa) {
		empresaComboBox.setSelectedItem(empresa);

	}

	@Override
	public void copyTo(Cliente entity) {
		entity.setNome(nomeTextField.getText());
		entity.setNomeCompleto(nomeCompletoTextField.getText());
		entity.setEmail(emailTextField.getText());
		entity.setGender(genderMaleRadio.isSelected());
		entity.setEmpresa(getEmprasaSelected());
		entity.setDigital1(digital1TextField.getText());
		entity.setDigital2(digital2TextField.getText());
		try {
			entity.setDataNascimento(DateFormat.parse(dataNascimentoTextField.getText()));
		} catch (ParseException e) {
			showMessage("Data de nascimento inválida");
		}
	}

	private Empresa getEmprasaSelected() {
		return (Empresa) empresaComboBox.getSelectedItem();
	}

	@Override
	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	@Override
	public JTextField getEmailTextField() {
		return emailTextField;
	}

	@Override
	public JPasswordField getDigital1PasswordField() {
		return digital1TextField;
	}

	@Override
	public JPasswordField getDigital2PasswordField() {
		return digital2TextField;
	}

	@Override
	public void put(Vector<Empresa> empresas) {
		empresaComboBox.removeAll();
		if (empresas != null) {
			for (Empresa empresa : empresas) {
				empresaComboBox.addItem(empresa);
			}
		}
	}

	@Override
	public JTextField getNomeCompletoTextField() {
		return nomeCompletoTextField;
	}

	@Override
	public JTextField getDataNascimentoTextField() {
		return dataNascimentoTextField;
	}

}
