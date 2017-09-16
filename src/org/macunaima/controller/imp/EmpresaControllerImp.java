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
	public Callback delete(Entity entity) {
		Callback callback = super.delete(entity);
		if (callback.callBack() == 1) {
			callback = deleteClientes((Empresa) entity);
			callback = deleteRegistros((Empresa) entity);
		}
		return callback;
	}

	private Callback deleteClientes(Empresa entity) {
		DBCollection clientesCollection = getCollection("clientes");
		DBCursor dbCursor = findDBCursor(clientesCollection, "empresaID", entity.getId());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Cliente cliente = new Cliente();
			cliente.fromEntity(dbObject);
			delete(cliente, clientesCollection);
		}
		return new Callback() {

			@Override
			public int callBack() {
				return 1;
			}
		};

	}

	private Callback deleteRegistros(Empresa entity) {
		DBCollection registrosCollection = getCollection("registros");
		DBCursor dbCursor = findDBCursor(registrosCollection, "empresaID", entity.getId());
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			Registro registro = new Registro();
			registro.fromEntity(dbObject);
			delete(registro, registrosCollection);
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
		return new String[]{"nome", "descontoCredito", "descontoAVista"};
	}

}
