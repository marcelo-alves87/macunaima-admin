package org.macunaima.controller.imp;

import org.macunaima.controller.UsuarioController;
import org.macunaima.domain.Usuario;

import com.mongodb.DBCollection;

public class UsuarioControllerImp extends ControllerImp<Usuario> implements UsuarioController {

	@Override
	protected String[] getDefaultParameters() {
		return new String[] { "login" };
	}

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("usuarios");
	}

	@Override
	protected Class<Usuario> getClazz() {
		return Usuario.class;
	}

}
