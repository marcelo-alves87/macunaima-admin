package org.macunaima.client.gui.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.client.application.ValidacaoClienteApplication;
import org.macunaima.domain.Cliente;

public class ValidacaoClienteDialogBox extends CustomDialog {

	private static Map<String, Integer> meses;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ValidacaoClienteApplication application;
	private Cliente cliente;

	public ValidacaoClienteDialogBox(JFrame jFrame, Cliente cliente, ValidacaoClienteApplication application,
			CloseDialogApplication closeDialogApplication) {
		super(jFrame, closeDialogApplication);
		this.application = application;
		this.cliente = cliente;
		createMesesMap();
	}

	private void createMesesMap() {
		if (meses == null) {
			meses = new HashMap<String, Integer>();
			meses.put("Janeiro", 1);
			meses.put("Fevereiro", 2);
			meses.put("Março", 3);
			meses.put("Abril", 4);
			meses.put("Maio", 5);
			meses.put("Junho", 6);
			meses.put("Julho", 7);
			meses.put("Agosto", 8);
			meses.put("Setembro", 9);
			meses.put("Outubro", 10);
			meses.put("Novembro", 11);
			meses.put("Dezembro", 12);
		}
	}

	@Override
	public void initPane() {

		JPanel jPanel = new JPanel();
		jPanel.setBackground(new Color(247, 213, 103));
		jPanel.setLayout(new BorderLayout());

		JLabel lblNewLabel_1 = new JLabel("<html>Por favor, selecione o mês do seu nascimento</html>");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Bernard MT Condensed", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		jPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel center = new JPanel();
		center.setBackground(new Color(247, 213, 103));
		center.setLayout(new FlowLayout());

		List<Integer> listMeses = createMesesIntegers();

		addMesesButton(center, listMeses);

		jPanel.add(center, BorderLayout.CENTER);

		contentPanel.add(jPanel, BorderLayout.NORTH);

	}

	private void addMesesButton(JPanel jPanel, List<Integer> listMeses) {
		for (Integer integer : listMeses) {
			jPanel.add(createJButton(integer));
		}

	}

	private List<Integer> createMesesIntegers() {
		List<Integer> integers = new ArrayList<Integer>();
		integers.add(application.getMesDataNascimentoCliente(cliente));
		for (int i = 0; i < 3; i++) {
			application.getRandomMonth(integers);
		}
		Collections.shuffle(integers);
		return integers;
	}

	private JButton createJButton(Integer mes) {
		ClientButton jButton = new ClientButton(getMesesKey(mes));
		jButton.addActionListener(getActionListener(mes));
		return jButton;
	}

	private String getMesesKey(Integer mes) {
		String string = null;
		for (Entry<String, Integer> entry : meses.entrySet()) {
			if (entry.getValue().equals(mes)) {
				string = entry.getKey();
				break;
			}
		}
		return string;
	}

	private ActionListener getActionListener(Integer month) {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				application.getValidacaoClienteActionListener(cliente, month);

			}
		};
	}

}
