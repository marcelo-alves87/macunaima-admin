package org.macunaima.client.gui.event;

import java.util.Vector;

import org.macunaima.client.application.LocalizacaoApplication;
import org.macunaima.client.application.ValidacaoClienteApplication;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Filial;

public interface EventBus {

	void showMessage(String cliente, String empresa, ActionListener actionListener);

	void showMessage(String message);

	void showMessage(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener);

	void openFiliaisDialog(Vector<Filial> filials);

	void openDialogPrimeiroAcesso(LocalizacaoApplication localizacaoApplication);

	void showCadastrarDigital1DialogBox(Cliente cliente, ActionListener actionListener);

	void showCadastrarDigital2DialogBox(Cliente cliente, ActionListener actionListener);

	void openValidarClienteDialogBox(Cliente cliente, ValidacaoClienteApplication application);
}
