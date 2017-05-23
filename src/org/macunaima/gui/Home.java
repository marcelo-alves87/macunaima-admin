package org.macunaima.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	 */
	public Home() {
		setTitle("Macuna\u00EDma Restaurante e Pizzaria");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\logo.png"));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 51, 3));
		contentPane.add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(239, 51, 3));
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(100, 0, 0, 0));
		tabbedPane.addTab("Página Inicial", null, panel_2, null);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Empresas");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\empresa.png"));
		btnNewButton.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton.setVerticalTextPosition(JButton.BOTTOM);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clientes");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\users.png"));
		btnNewButton_1.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton_1.setVerticalTextPosition(JButton.BOTTOM);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Relat\u00F3rios");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\relatorios.png"));
		btnNewButton_2.setHorizontalTextPosition(JButton.CENTER);
		btnNewButton_2.setVerticalTextPosition(JButton.BOTTOM);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Empresas", null, panel_3, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Clientes", null, panel_5, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Relatórios", null, panel_4, null);
	}

}
