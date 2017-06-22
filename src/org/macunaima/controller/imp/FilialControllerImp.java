package org.macunaima.controller.imp;

import org.macunaima.controller.FilialController;
import org.macunaima.domain.Filial;

import com.mongodb.DBCollection;

public class FilialControllerImp extends ControllerImp<Filial> implements FilialController {

	@Override
	protected String[] getDefaultParameters() {
		return new String[] { "nome" };
	}

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("filiais");
	}

	@Override
	protected Class<Filial> getClazz() {
		return Filial.class;
	}

}
