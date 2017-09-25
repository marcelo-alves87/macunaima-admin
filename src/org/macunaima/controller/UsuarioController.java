package org.macunaima.controller;

import org.macunaima.domain.Usuario;
import org.macunaima.domain.UsuarioCallback;

public interface UsuarioController extends Controller<Usuario> {

	UsuarioCallback validateLogin(String username, String password);

}
