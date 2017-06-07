package org.macunaima.controller;

import java.util.Vector;

import org.macunaima.domain.Callback;
import org.macunaima.domain.Empresa;

public interface EmpresaController {

	Vector<Empresa> find(String search);

	Callback persist(Empresa empresa);
	
	Callback delete(Empresa empresa);
}
