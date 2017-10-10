package org.macunaima.client.gui.event;

import java.util.Vector;

import org.macunaima.client.application.CadastrarDigital1Application;
import org.macunaima.client.application.CadastrarDigital2Application;
import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.client.application.LocalizacaoApplication;
import org.macunaima.client.application.ValidacaoClienteApplication;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Filial;

public interface EventBus {

	void showMessage(String cliente, String empresa, ActionListener actionListener,
			CloseDialogApplication closeDialogApplication);

	void showMessage(String message, CloseDialogApplication closeDialogApplication);

	void showMessage(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener, CloseDialogApplication closeDialogApplication);

	void openFiliaisDialog(Vector<Filial> filials, CloseDialogApplication closeDialogApplication);

	void openDialogPrimeiroAcesso(LocalizacaoApplication localizacaoApplication,
			CloseDialogApplication closeDialogApplication);

	void showCadastrarDigital1DialogBox(Cliente cliente, CadastrarDigital1Application application,
			CloseDialogApplication closeDialogApplication);

	void showCadastrarDigital2DialogBox(Cliente cliente, CadastrarDigital2Application application,
			CloseDialogApplication closeDialogApplication);

	void openValidarClienteDialogBox(Cliente cliente, ValidacaoClienteApplication application,
			CloseDialogApplication closeDialogApplication);
}
