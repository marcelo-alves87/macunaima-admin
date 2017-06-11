package org.macunaima.controller.imp;

import org.macunaima.controller.EmpresaController;
import org.macunaima.domain.Empresa;

import com.mongodb.DBCollection;

public class EmpresaControllerImp extends ControllerImp<Empresa> implements EmpresaController {

	@Override
	protected java.lang.Class<Empresa> getInstance() {
		return Empresa.class;
	}

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("empresas");
	}

}
