package org.macunaima.gui.ui;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.HomeApplication;

public class HomePanel extends JPanel implements HomeApplication.HomeDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HomeButton empresasButton;
	private HomeButton clientesButton;
	private HomeButton filiaisButton;

	public HomePanel() {
		super();

		setBorder(new EmptyBorder(100, 0, 0, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		empresasButton = new HomeButton("Empresas", "C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\empresa.png");
		add(empresasButton);

		clientesButton = new HomeButton("Clientes", "C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\users.png");
		add(clientesButton);

		HomeButton btnNewButton_2 = new HomeButton("Relat\u00F3rios",
				"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\relatorios.png");
		add(btnNewButton_2);

		filiaisButton = new HomeButton("Filiais",
				"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\link_company.png");
		add(filiaisButton);
	}

	@Override
	public JButton getEmpresasButton() {
		return empresasButton;
	}

	@Override
	public Component getContent() {
		return this;
	}

	@Override
	public JButton getClientesButton() {
		return clientesButton;
	}

	@Override
	public JButton getFiliaisButton() {
		return filiaisButton;
	}

}
