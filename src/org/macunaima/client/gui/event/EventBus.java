package org.macunaima.client.gui.event;

public interface EventBus {

	void showMessage(String cliente, String empresa, ActionListener actionListener);

	void showMessage(String message);

	void showMessage(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener);
}
