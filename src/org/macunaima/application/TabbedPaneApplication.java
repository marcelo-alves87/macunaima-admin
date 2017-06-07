package org.macunaima.application;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TabbedPaneApplication {

	public interface Display {
		JButton getCloseButton();

		void close(Component component);
	}

	private Display diplay;
	private Component component;

	public TabbedPaneApplication(Display display, Component component) {
		this.diplay = display;
		this.component = component;
	}

	public void bind() {
		this.diplay.getCloseButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();

			}
		});

	}

	protected void close() {
		this.diplay.close(this.component);

	}

}
