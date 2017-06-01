package org.macunaima.gui.ui;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.HomeApplication;

public class HomePanel extends JPanel implements HomeApplication.HomeDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HomeButton empresasButton;

	public HomePanel() {
		super();

		setBorder(new EmptyBorder(100, 0, 0, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		empresasButton = new HomeButton("Empresas",
				"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\empresa.png");
		add(empresasButton);

		HomeButton btnNewButton_1 = new HomeButton("Clientes",
				"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\users.png");
		add(btnNewButton_1);

		HomeButton btnNewButton_2 = new HomeButton("Relat\u00F3rios",
				"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\relatorios.png");
		add(btnNewButton_2);
	}

	@Override
	public AbstractButton getEmpresasButton() {
		return empresasButton;
	}

	@Override
	public Component getContent() {
		return this;
	}

}
