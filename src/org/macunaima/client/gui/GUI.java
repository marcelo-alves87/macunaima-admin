package org.macunaima.client.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.macunaima.client.application.Application;
import org.macunaima.client.gui.ui.Content;
import org.macunaima.client.gui.ui.EventBus;
import org.macunaima.client.gui.ui.EventBusImp;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GraphicsDevice graphicsDevice;
	private EventBus eventBus;

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

		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		this.eventBus = new EventBusImp(this);

		setContentPane(getContent());
		

	}

	private Container getContent() {
		Content content = new Content();
		Application application = new Application(eventBus);
		application.setDisplay(content);
		return content;
	}

	private Container getTeste() {
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.ORANGE);
		jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		jPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(100, 0, 100, 0));
		panel_1.setBackground(Color.ORANGE);
		jPanel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon2.png"));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 130, 0));
		jPanel.add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Por favor, insira sua digital");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(50, 0, 0, 0));
		panel_2.setBackground(Color.ORANGE);
		panel.add(panel_2, BorderLayout.CENTER);

		JPasswordField passwordField = new JPasswordField();
		panel_2.add(passwordField);
		passwordField.setColumns(100);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBackground(Color.ORANGE);
		passwordField.requestFocus();
		return jPanel;
	}

}
