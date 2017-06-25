package org.macunaima.client.gui.event;

import java.util.Vector;

import org.macunaima.domain.Filial;

public interface EventBus {

	void showMessage(String cliente, String empresa, ActionListener actionListener);

	void showMessage(String message);

	void showMessage(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener);

	void showMessage(Vector<Filial> filials);
}
