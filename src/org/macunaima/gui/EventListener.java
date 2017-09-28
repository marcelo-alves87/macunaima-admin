package org.macunaima.gui;

import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Usuario;

public interface EventListener {

	void goToEmpresasPanel();

	void goToEditEmpresa(Empresa empresa);

	void closeEditEmpresa();

	void goToClientesPanel();

	void goToEditCliente(Cliente cliente);

	void closeEditCliente();

	void goToFiliaisPanel();

	void goToEditFilial(Filial filial);

	void closeEditFilial();

	void goToRelatoriosPanel();

	void goToEditUsuario(Usuario usuario);

	void closeEditUsuario();

	void goToUsuariosPanel();

	void createLoginPanel();

	void closeLoginPanel();

	void goToHomePanel(boolean administrador);

	void goToLoginPanel();

}
