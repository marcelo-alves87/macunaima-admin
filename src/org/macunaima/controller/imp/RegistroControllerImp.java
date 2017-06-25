package org.macunaima.controller.imp;

import org.macunaima.controller.RegistroController;
import org.macunaima.domain.Registro;

import com.mongodb.DBCollection;

public class RegistroControllerImp extends ControllerImp<Registro> implements RegistroController {

	@Override
	protected String[] getDefaultParameters() {
		return new String[] { "_id" };
	}

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("registros");
	}

	@Override
	protected Class<Registro> getClazz() {
		return Registro.class;
	}

}
