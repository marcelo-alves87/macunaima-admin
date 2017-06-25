package org.macunaima.client.gui;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import org.macunaima.client.application.Application;
import org.macunaima.client.gui.event.ActionListener;
import org.macunaima.client.gui.event.EventBus;
import org.macunaima.client.gui.ui.AskDialog;
import org.macunaima.client.gui.ui.ButtonsDialog;
import org.macunaima.client.gui.ui.Content;
import org.macunaima.client.gui.ui.FilialDialog;
import org.macunaima.client.gui.ui.MessageDialog;
import org.macunaima.domain.Filial;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GraphicsDevice graphicsDevice;
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
					graphicsDevice.setFullScreenWindow(frame);

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

		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphicsDevice = e.getDefaultScreenDevice();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		createEventBus();

		setContentPane(getContent());

	}

	private void createEventBus() {
		this.eventBus = new EventBus() {

			@Override
			public void showMessage(String cliente, String empresa, ActionListener actionListener) {
				showDialog(cliente, empresa, actionListener);
			}

			@Override
			public void showMessage(String message) {
				showDialog(message);

			}

			@Override
			public void showMessage(String descontoCredito, String descontoAVista,
					ActionListener descontoCreditoActionListener, ActionListener descontoAVistaActionListener) {
				showDialog(descontoCredito, descontoAVista, descontoCreditoActionListener,
						descontoAVistaActionListener);

			}

			@Override
			public void showMessage(Vector<Filial> filials) {
				showDialog(filials);

			}
		};
	}

	private Container getContent() {
		Content content = new Content();
		application = new Application(eventBus);
		application.setDisplay(content);
		return content;
	}

	private void showDialog(String cliente, String empresa, ActionListener actionListener) {
		AskDialog dialog = new AskDialog(this, cliente, empresa, actionListener);
		dialog.initPane();
		dialog.setVisible(true);
	}

	private void showDialog(String descontoCredito, String descontoAVista, ActionListener descontoCreditoActionListener,
			ActionListener descontoAVistaActionListener) {
		ButtonsDialog dialog = new ButtonsDialog(this, descontoCredito, descontoAVista, descontoCreditoActionListener,
				descontoAVistaActionListener);
		dialog.initPane();
		dialog.setVisible(true);

	}

	private void showDialog(String message) {
		MessageDialog dialog = new MessageDialog(this, message);
		dialog.initPane();
		dialog.addWindowListener(getDialogListener());
		dialog.setVisible(true);
	}

	protected void showDialog(Vector<Filial> filials) {
		FilialDialog dialog = new FilialDialog(this, filials);
		dialog.initPane();
		dialog.addWindowListener(getDialogListener());
		dialog.setVisible(true);
	}

	private WindowListener getDialogListener() {
		return new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent e) {
				application.close();

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}
		};
	}
}
