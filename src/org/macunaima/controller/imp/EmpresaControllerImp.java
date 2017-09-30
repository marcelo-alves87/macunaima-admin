package org.macunaima.controller.imp;

import org.macunaima.controller.EmpresaController;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Cliente;
import org.macunaima.domain.Empresa;
import org.macunaima.domain.Entity;
import org.macunaima.domain.Registro;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class EmpresaControllerImp extends ControllerImp<Empresa> implements EmpresaController {

	@Override
	protected java.lang.Class<Empresa> getClazz() {
		return Empresa.class;
	}

	@Override
	protected DBCollection getDefaultCollection() {
		return super.getCollection("empresas");
	}

	@Override
	public Callback delete(Entity entity, boolean isAdministrador) {
		Callback callback = super.delete(entity, isAdministrador);
		if (callback.callBack() == 1) {
			callback = deleteClientes((Empresa) entity, isAdministrador);
			callback = deleteRegistros((Empresa) entity, isAdministrador);
		}
		return callback;
	}

	private Callback deleteClientes(Empresa entity, boolean isAdministrador) {
		DBCollection clientesCollection = getCollection("clientes");
		DBCursor dbCursor = findDBCursor(clientesCollection, "empresaID", entity.getId());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Cliente cliente = new Cliente();
			cliente.fromEntity(dbObject);
			delete(cliente, clientesCollection, isAdministrador);
		}
		return new Callback() {

			@Override
			public int callBack() {
				return 1;
			}
		};

	}

	private Callback deleteRegistros(Empresa entity, boolean isAdministrador) {
		DBCollection registrosCollection = getCollection("registros");
		DBCursor dbCursor = findDBCursor(registrosCollection, "empresaID", entity.getId());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Registro registro = new Registro();
			registro.fromEntity(dbObject);
			delete(registro, registrosCollection, isAdministrador);
		}
		return new Callback() {

			@Override
			public int callBack() {
				return 1;
			}
		};

	}

	@Override
	protected String[] getDefaultParameters() {
		return new String[] { "nome", "descontoCredito", "descontoAVista" };
	}

	@Override
	public Callback persist(Empresa entity, boolean isAdministrador) {
		Callback callback = super.persist(entity, isAdministrador);
		if (callback.callBack() == 1) {
			callback = updateRegistros(entity);
		}
		return callback;
	}

	private Callback updateRegistros(Empresa entity) {
		DBCollection registrosCollection = getCollection("registros");
		DBCursor dbCursor = findDBCursor(registrosCollection, "empresaID", entity.getId());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Registro registro = new Registro();
			registro.fromEntity(dbObject);
			if (registro.getCliente() != null) {
				registro.getCliente().setEmpresa(entity);
			}
			persist(registro, registrosCollection, true);
		}
		return new Callback() {

			@Override
			public int callBack() {
				return 1;
			}
		};

	}

}
