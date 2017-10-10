package org.macunaima.client.gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import org.macunaima.client.application.Application;
import org.macunaima.client.application.CadastrarDigital1Application;
import org.macunaima.client.application.CadastrarDigital2Application;
import org.macunaima.client.application.CloseDialogApplication;
import org.macunaima.client.application.LocalizacaoApplication;
import org.macunaima.client.application.ValidacaoClienteApplication;
import org.macunaima.client.gui.event.ActionListener;
import org.macunaima.client.gui.event.EventBus;
import org.macunaima.client.gui.ui.AskDialog;
import org.macunaima.client.gui.ui.ButtonsDialog;
import org.macunaima.client.gui.ui.CadastrarDigital1Dialog;
import org.macunaima.client.gui.ui.CadastrarDigital2Dialog;
import org.macunaima.client.gui.ui.Content;
import org.macunaima.client.gui.ui.FilialDialog;
import org.macunaima.client.gui.ui.LocalizacaoDialog;
import org.macunaima.client.gui.ui.MessageDialog;
import org.macunaima.client.gui.ui.ValidacaoClienteDialogBox;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Filial;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EventBus eventBus;
	private Application application;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setUndecorated(true);
					frame.setResizable(false);
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		createEventBus();

		setContentPane(getContent());

	}

	private void createEventBus() {
		this.eventBus = new EventBus() {

			@Override
			public void showMessage(String cliente, String empresa, ActionListener actionListener,
					CloseDialogApplication closeDialogApplication) {
				showDialog(cliente, empresa, actionListener, closeDialogApplication);
			}

			@Override
			public void showMessage(String message, CloseDialogApplication closeDialogApplication) {
				showDialog(message, closeDialogApplication);

			}

			@Override
			public void showMessage(String descontoCredito, String descontoAVista,
					ActionListener descontoCreditoActionListener, ActionListener descontoAVistaActionListener,
					CloseDialogApplication closeDialogApplication) {
				showDialog(descontoCredito, descontoAVista, descontoCreditoActionListener, descontoAVistaActionListener,
						closeDialogApplication);

			}

			@Override
			public void openFiliaisDialog(Vector<Filial> filials, CloseDialogApplication closeDialogApplication) {
				openFilialDialog(filials, closeDialogApplication);
			}

			@Override
			public void openDialogPrimeiroAcesso(LocalizacaoApplication localizacaoApplication,
					CloseDialogApplication closeDialogApplication) {
				openPrimeiroAcessoDialog(localizacaoApplication, closeDialogApplication);

			}

			@Override
			public void openValidarClienteDialogBox(Cliente cliente, ValidacaoClienteApplication application,
					CloseDialogApplication closeDialogApplication) {
				openClienteValidarDialogBox(cliente, application, closeDialogApplication);

			}

			@Override
			public void showCadastrarDigital1DialogBox(Cliente cliente, CadastrarDigital1Application application,
					CloseDialogApplication closeDialogApplication) {
				openCadastrarDigital1Dialox(cliente, application, closeDialogApplication);

			}

			@Override
			public void showCadastrarDigital2DialogBox(Cliente cliente, CadastrarDigital2Application application,
					CloseDialogApplication closeDialogApplication) {
				openCadastrarDigital2Dialox(cliente, application, closeDialogApplication);

			}

		};
	}

	protected void openCadastrarDigital1Dialox(Cliente cliente, CadastrarDigital1Application application,
			CloseDialogApplication closeDialogApplication) {
		CadastrarDigital1Dialog cadastrarDigital1Dialog = new CadastrarDigital1Dialog(this, cliente, application,
				closeDialogApplication);
		cadastrarDigital1Dialog.initPane();
		cadastrarDigital1Dialog.setVisible(true);

	}

	protected void openCadastrarDigital2Dialox(Cliente cliente, CadastrarDigital2Application application,
			CloseDialogApplication closeDialogApplication) {
		CadastrarDigital2Dialog cadastrarDigita2Dialog = new CadastrarDigital2Dialog(this, cliente, application,
				closeDialogApplication);
		cadastrarDigita2Dialog.initPane();
		cadastrarDigita2Dialog.setVisible(true);
	}

	protected void openClienteValidarDialogBox(Cliente cliente, ValidacaoClienteApplication application,
			CloseDialogApplication closeDialogApplication) {
		ValidacaoClienteDialogBox validacaoClienteDialog = new ValidacaoClienteDialogBox(this, cliente, application,
				closeDialogApplication);
		validacaoClienteDialog.initPane();
		validacaoClienteDialog.setVisible(true);
	}

	protected void openPrimeiroAcessoDialog(LocalizacaoApplication localizacaoApplication,
			CloseDialogApplication closeDialogApplication) {
		LocalizacaoDialog localizacaoDialog = new LocalizacaoDialog(this, localizacaoApplication,
				closeDialogApplication);
		localizacaoDialog.initPane();
		localizacaoDialog.setVisible(true);

	}

	private Container getContent() {
		Content content = new Content();
		application = new Application(eventBus);
		application.setDisplay(content);
		return content;
	}

	private void showDialog(String cliente, String empresa, ActionListener actionListener,
			CloseDialogApplication closeDialogApplication) {
		AskDialog dialog = new AskDialog(this, cliente, empresa, actionListener, closeDialogApplication);
		dialog.initPane();
		dialog.setVisible(true);
	}

	private void showDialog(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener, CloseDialogApplication closeDialogApplication) {
		ButtonsDialog dialog = new ButtonsDialog(this, descontoCredito, descontoAVista, descontoCreditoActionListener,
				descontoAVistaActionListener, closeDialogApplication);
		dialog.initPane();
		dialog.setVisible(true);

	}

	private void showDialog(String message, CloseDialogApplication closeDialogApplication) {
		MessageDialog dialog = new MessageDialog(this, message, closeDialogApplication);
		dialog.initPane();
		dialog.setVisible(true);
	}

	protected void openFilialDialog(Vector<Filial> filials, CloseDialogApplication closeDialogApplication) {
		FilialDialog dialog = new FilialDialog(this, filials, closeDialogApplication);
		dialog.initPane();
		dialog.setVisible(true);
	}

}
