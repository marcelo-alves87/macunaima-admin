package org.macunaima.application;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Usuario;
import org.macunaima.service.DefaultService;

public class UsuariosApplication extends AbstractListApplication<Usuario> {

	protected Usuario convertToUsuario(int row) {
		Usuario usuario = new Usuario();
		usuario.setId((String) getListDisplay().getJTable().getModel().getValueAt(row, 1));
		return usuario;
	}

	@Override
	protected void goToEntity(int row) {
		Usuario usuario = convertToUsuario(row);
		getEventListener().goToEditUsuario(usuario);
	}

	@Override
	protected void goToNewEntity() {
		getEventListener().goToEditUsuario(null);

	}

	@Override
	protected Controller<Usuario> getController() {
		return DefaultService.getUsuarioController();
	}

}
