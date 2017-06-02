package org.macunaima.application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.macunaima.gui.EventListener;

public class HomeApplication implements Application {

	public interface HomeDisplay extends Display {

		JButton getEmpresasButton();
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

}
