package org.macunaima.client.gui.ui;

import javax.swing.JFrame;

public class EventBusImp implements EventBus {

	private JFrame frame;

	public EventBusImp(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void showMessage(String message) {
		new BDialog(frame);
	}

}
