package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.macunaima.gui.EventListener;

public class HomeApplication implements Application {

	public interface HomeDisplay extends Display {

		JButton getEmpresasButton();

		JButton getClientesButton();

		JButton getFiliaisButton();

		JButton getRelatoriosButton();

		JButton getUsuariosButton();
	}

	private HomeDisplay display;
	private EventListener eventListener;

	private void bind() {
		this.display.getEmpresasButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventListener.goToEmpresasPanel();

			}
		});

		this.display.getClientesButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventListener.goToClientesPanel();

			}
		});

		this.display.getFiliaisButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventListener.goToFiliaisPanel();

			}
		});

		this.display.getRelatoriosButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventListener.goToRelatoriosPanel();

			}
		});

		this.display.getUsuariosButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				eventListener.goToUsuariosPanel();

			}
		});

	}

	@Override
	public Display getDisplay() {
		return this.display;
	}

	@Override
	public void setDisplay(Display display) {
		this.display = (HomeDisplay) display;
		bind();
	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;

	}

}
