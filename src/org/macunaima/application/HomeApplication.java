package org.macunaima.application;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;

import org.macunaima.gui.EventListener;

public class HomeApplication implements Application {

	public interface HomeDisplay extends Display {

		AbstractButton getEmpresasButton();
	}

	private HomeDisplay display;
	private EventListener eventListener;


	private void bind() {
		this.display.getEmpresasButton().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("a");

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("b");

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				System.out.println("c");

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("d");

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("e");

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
