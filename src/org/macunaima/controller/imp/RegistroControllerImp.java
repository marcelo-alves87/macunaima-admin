package org.macunaima.controller.imp;

import org.macunaima.controller.RegistroController;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Registro;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;

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

	@Override
	public Callback persist(Registro entity) {
		updateFilial(entity);
		return super.persist(entity);
	}

	private void updateFilial(Registro registro) {
		checkConnection();
		DBObject dbObject = findById(registro.getFilial().getId(), "filiais");
		Filial filial = new Filial();
		filial.fromEntity(dbObject);
		registro.setFilial(filial);
	}

}
