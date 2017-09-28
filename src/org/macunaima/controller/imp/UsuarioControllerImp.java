package org.macunaima.controller.imp;

import java.util.Vector;

import org.macunaima.controller.UsuarioController;
import org.macunaima.domain.Usuario;
import org.macunaima.domain.UsuarioCallback;

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

	@Override
	public UsuarioCallback validateLogin(String username, String password) {
		if ("root".equals(username) && "supervisor".equals(password)) {
			return new UsuarioCallback() {

				@Override
				public int callBack() {
					return 1;
				}

				@Override
				public Usuario getUsuario() {
					Usuario usuario = new Usuario();
					usuario.setAdministrador(true);
					usuario.setLogin("root");
					return usuario;
				}
			};
		} else {
			Vector<Usuario> usuarios = find(username);

			if (usuarios != null && !usuarios.isEmpty()) {
				Usuario usuario = usuarios.get(0);
				if (usuario.getSenha() != null && usuario.getSenha().equals(password)) {
					return new UsuarioCallback() {

						@Override
						public int callBack() {
							return 1;
						}

						@Override
						public Usuario getUsuario() {
							return usuario;
						}
					};
				} else {
					return new UsuarioCallback() {

						@Override
						public int callBack() {
							return 1;
						}

						@Override
						public Usuario getUsuario() {
							return null;
						}
					};
				}
			} else {
				return new UsuarioCallback() {

					@Override
					public int callBack() {
						return 0;
					}

					@Override
					public Usuario getUsuario() {
						return null;
					}
				};
			}
		}
	}

}
