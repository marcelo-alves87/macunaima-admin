package org.macunaima.controller;

import java.util.Vector;

import org.macunaima.domain.Empresa;

public interface EmpresaController {

	Vector<Empresa> find(String search);

	void persist(Empresa empresa);
}
