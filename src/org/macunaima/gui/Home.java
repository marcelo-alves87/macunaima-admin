package org.macunaima.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.Application;
import org.macunaima.gui.ui.ColunaLaranja;
import org.macunaima.gui.ui.HomePanel;
import org.macunaima.gui.ui.Logomarca;

public class Home extends JFrame {

	private class HomeEventListener implements EventListener {

		@Override
		public void createHomePanel() {
			Application homeApplication = Application.getDefaultHomeApplication();
			HomePanel homePanel = new HomePanel();
			homeApplication.setDisplay(homePanel);
			components.put("empresas", homeApplication);
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Map<String, Application> components;
	private JTabbedPane tabbedPane;
	private EventListener eventListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setTitle("Macuna\u00EDma Restaurante e Pizzaria");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		components = new HashMap<String, Application>();
		eventListener = new HomeEventListener();
		addNorth();

		addWest();

		addEast();

		addCenter();
	}

	private void addCenter() {
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		eventListener.createHomePanel();
		tabbedPane.addTab("Página Inicial", null, components.get("empresas").getDisplay().getContent(), null);

	}

	private void addEast() {
		contentPane.add(new ColunaLaranja(), BorderLayout.EAST);
	}

	private void addWest() {
		contentPane.add(new ColunaLaranja(), BorderLayout.WEST);
	}

	private void addNorth() {
		contentPane.add(new Logomarca(), BorderLayout.NORTH);
	}

}
