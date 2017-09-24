package org.macunaima.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.macunaima.application.Application;
import org.macunaima.application.TabbedPaneApplication;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Usuario;
import org.macunaima.gui.ui.ClienteEditTabPanel;
import org.macunaima.gui.ui.ClienteListTabPanel;
import org.macunaima.gui.ui.ColunaLaranja;
import org.macunaima.gui.ui.DefaultTabPanel;
import org.macunaima.gui.ui.EmpresaEditTabPanel;
import org.macunaima.gui.ui.EmpresaListTabPanel;
import org.macunaima.gui.ui.FilialEditTabPanel;
import org.macunaima.gui.ui.FilialListTabPanel;
import org.macunaima.gui.ui.HomePanel;
import org.macunaima.gui.ui.Logomarca;
import org.macunaima.gui.ui.RelatoriosTabPanel;
import org.macunaima.gui.ui.UsuarioEditTabPanel;
import org.macunaima.gui.ui.UsuarioListTabPanel;

public class Home extends JFrame {

	private class HomeEventListener implements EventListener {

		@Override
		public void createHomePanel() {
			Application homeApplication = Application.getHomeApplication();
			HomePanel homePanel = new HomePanel();
			homeApplication.setDisplay(homePanel);
			homeApplication.setEventListener(eventListener);
			components.put("home", homeApplication);
		}

		private void createEmpresasPanel() {
			Application empresasApplication = Application.getEmpresasApplication();
			EmpresaListTabPanel empresasTabPanel = new EmpresaListTabPanel("Nova Empresa",
					"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\new_empresa_12.png");
			empresasApplication.setDisplay(empresasTabPanel);
			empresasApplication.setEventListener(eventListener);
			components.put("empresas", empresasApplication);
		}

		@Override
		public void goToEmpresasPanel() {
			Application empresasApplication = components.get("empresas");
			if (empresasApplication == null) {
				createEmpresasPanel();
				empresasApplication = components.get("empresas");
			}
			addToTabbedPane("Empresas", "empresas", true);
			tabbedPane.setSelectedComponent(empresasApplication.getDisplay().getContent());

		}

		@Override
		public void goToEditEmpresa(Empresa empresa) {
			closeEditEmpresa();
			createEmpresaPanel(empresa);
			Application empresaApplication = components.get("empresa");
			addToTabbedPane("Empresa", "empresa", true);
			tabbedPane.setSelectedComponent(empresaApplication.getDisplay().getContent());

		}

		private void createEmpresaPanel(Empresa empresa) {
			Application empresaApplication = Application.getEmpresaApplication(empresa);
			EmpresaEditTabPanel empresaEditTabPanel = new EmpresaEditTabPanel("Empresa");
			empresaApplication.setDisplay(empresaEditTabPanel);
			empresaApplication.setEventListener(eventListener);
			components.put("empresa", empresaApplication);

		}

		@Override
		public void closeEditEmpresa() {
			Application empresaApplication = components.get("empresa");
			if (empresaApplication != null) {
				tabbedPane.remove(empresaApplication.getDisplay().getContent());
				components.remove("empresa");
			}
		}

		@Override
		public void goToEditCliente(Cliente cliente) {
			closeEditCliente();
			createClientePanel(cliente);
			Application clienteApplication = components.get("cliente");
			addToTabbedPane("Cliente", "cliente", true);
			tabbedPane.setSelectedComponent(clienteApplication.getDisplay().getContent());

		}

		private void createClientePanel(Cliente cliente) {
			Application clienteApplication = Application.getClienteApplication(cliente);
			ClienteEditTabPanel clienteEditTabPanel = new ClienteEditTabPanel("Cliente");
			clienteApplication.setDisplay(clienteEditTabPanel);
			clienteApplication.setEventListener(eventListener);
			components.put("cliente", clienteApplication);
		}

		@Override
		public void goToClientesPanel() {
			Application clientesApplication = components.get("clientes");
			if (clientesApplication == null) {
				createClientesPanel();
				clientesApplication = components.get("clientes");
			}
			addToTabbedPane("Clientes", "clientes", true);
			tabbedPane.setSelectedComponent(clientesApplication.getDisplay().getContent());

		}

		private void createClientesPanel() {
			Application clientesApplication = Application.getClientesApplication();
			ClienteListTabPanel clientesTabPanel = new ClienteListTabPanel("Novo Cliente",
					"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\new_cliente.png");
			clientesApplication.setDisplay(clientesTabPanel);
			clientesApplication.setEventListener(eventListener);
			components.put("clientes", clientesApplication);

		}

		@Override
		public void closeEditCliente() {
			Application clienteApplication = components.get("cliente");
			if (clienteApplication != null) {
				tabbedPane.remove(clienteApplication.getDisplay().getContent());
				components.remove("cliente");
			}
		}

		@Override
		public void goToEditFilial(Filial filial) {
			closeEditFilial();
			createFilialPanel(filial);
			Application filialApplication = components.get("filial");
			addToTabbedPane("Filial", "filial", true);
			tabbedPane.setSelectedComponent(filialApplication.getDisplay().getContent());

		}

		private void createFilialPanel(Filial filial) {
			Application filialApplication = Application.getFilialApplication(filial);
			FilialEditTabPanel filialEditTabPanel = new FilialEditTabPanel("Filial");
			filialApplication.setDisplay(filialEditTabPanel);
			filialApplication.setEventListener(eventListener);
			components.put("filial", filialApplication);
		}

		@Override
		public void goToFiliaisPanel() {
			Application filiaisApplication = components.get("filiais");
			if (filiaisApplication == null) {
				createFiliaisPanel();
				filiaisApplication = components.get("filiais");
			}
			addToTabbedPane("Filiais", "filiais", true);
			tabbedPane.setSelectedComponent(filiaisApplication.getDisplay().getContent());

		}

		private void createFiliaisPanel() {
			Application filiaisApplication = Application.getFiliaisApplication();
			FilialListTabPanel filiaisTabPanel = new FilialListTabPanel("Nova Filial",
					"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\new_link_company.png");
			filiaisApplication.setDisplay(filiaisTabPanel);
			filiaisApplication.setEventListener(eventListener);
			components.put("filiais", filiaisApplication);

		}

		@Override
		public void closeEditFilial() {
			Application filialApplication = components.get("filial");
			if (filialApplication != null) {
				tabbedPane.remove(filialApplication.getDisplay().getContent());
				components.remove("filial");
			}
		}

		@Override
		public void goToRelatoriosPanel() {
			Application relatoriosApplication = components.get("relatorios");
			if (relatoriosApplication == null) {
				createRelatoriosPanel();
				relatoriosApplication = components.get("relatorios");
			}
			addToTabbedPane("Relatórios", "relatorios", true);
			tabbedPane.setSelectedComponent(relatoriosApplication.getDisplay().getContent());
		}

		private void createRelatoriosPanel() {
			Application relatoriosApplication = Application.getRelatoriosApplication();
			RelatoriosTabPanel relatoriosTabPanel = new RelatoriosTabPanel();
			relatoriosApplication.setDisplay(relatoriosTabPanel);
			relatoriosApplication.setEventListener(eventListener);
			components.put("relatorios", relatoriosApplication);
			
		}

		@Override
		public void goToEditUsuario(Usuario usuario) {
			closeEditUsuario();
			createUsuarioPanel(usuario);
			Application usuarioApplication = components.get("usuario");
			addToTabbedPane("Usuário", "usuario", true);
			tabbedPane.setSelectedComponent(usuarioApplication.getDisplay().getContent());
		}

		private void createUsuarioPanel(Usuario usuario) {
			Application usuarioApplication = Application.getUsuarioApplication(usuario);
			UsuarioEditTabPanel usuarioEditTabPanel = new UsuarioEditTabPanel("Usuário");
			usuarioApplication.setDisplay(usuarioEditTabPanel);
			usuarioApplication.setEventListener(eventListener);
			components.put("usuario", usuarioApplication);
		}

		@Override
		public void closeEditUsuario() {
			Application usuarioApplication = components.get("usuario");
			if (usuarioApplication != null) {
				tabbedPane.remove(usuarioApplication.getDisplay().getContent());
				components.remove("usuario");
			}
			
		}

		@Override
		public void goToUsuariosPanel() {
			Application usuariosApplication = components.get("usuarios");
			if (usuariosApplication == null) {
				createUsuariosPanel();
				usuariosApplication = components.get("usuarios");
			}
			addToTabbedPane("Usuários", "usuarios", true);
			tabbedPane.setSelectedComponent(usuariosApplication.getDisplay().getContent());
			
		}

		private void createUsuariosPanel() {
			Application usuariosApplication = Application.getUsuariosApplication();
			UsuarioListTabPanel usuariosTabPanel = new UsuarioListTabPanel("Novo Usuário",
					"C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\new_usuarios.png");
			usuariosApplication.setDisplay(usuariosTabPanel);
			usuariosApplication.setEventListener(eventListener);
			components.put("usuarios", usuariosApplication);
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
	private JLabel lblNewLabel;

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
		setTitle("Desconto Fácil - v1.00");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Marcelo\\workspace\\macunaima-admin\\img\\icon-desconto.png"));
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

		addToTabbedPane("Início", "home", false);
	}

	private void addToTabbedPane(String title, String componentName, boolean withCloseButtton) {
		tabbedPane.addTab(title, null, components.get(componentName).getDisplay().getContent(), null);
		int index = tabbedPane.indexOfTab(title);

		DefaultTabPanel defaultTabPanel = new DefaultTabPanel(title, tabbedPane, withCloseButtton);
		TabbedPaneApplication tabbedPaneApplication = new TabbedPaneApplication(defaultTabPanel,
				components.get(componentName).getDisplay().getContent());
		tabbedPaneApplication.bind();
		tabbedPane.setTabComponentAt(index, defaultTabPanel);
	}

	private void addEast() {
		contentPane.add(new ColunaLaranja(), BorderLayout.EAST);
	}

	private void addWest() {
		contentPane.add(new ColunaLaranja(), BorderLayout.WEST);
	}

	private void addNorth() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout(0, 0));
		
		jPanel.add(new Logomarca(), BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("Desconto F\u00E1cil");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jPanel.add(lblNewLabel, BorderLayout.SOUTH);

		contentPane.add(jPanel, BorderLayout.NORTH);
	}

}
