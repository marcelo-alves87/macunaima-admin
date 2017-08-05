package org.macunaima.controller;

import org.macunaima.domain.Registro;
import org.macunaima.domain.RegistroCallback;

public interface RegistroController extends Controller<Registro> {
	
	RegistroCallback persistRegistro(Registro registro); 

}
