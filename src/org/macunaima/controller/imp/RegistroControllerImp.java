package org.macunaima.controller.imp;

import java.util.Date;

import org.macunaima.controller.RegistroController;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Filial;
import org.macunaima.domain.Registro;
import org.macunaima.domain.RegistroCallback;

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

	@Override
	public RegistroCallback persistRegistro(Registro registro) {
		Callback callback = this.persist(registro);
		if (callback.callBack() == 1) {
			return new RegistroCallback() {

				@Override
				public int callBack() {
					return 1;
				}

				@Override
				public String nomeFilial() {
					return registro.getFilial().getNome();
				}

				@Override
				public String nomeEmpresa() {
					return registro.getCliente().getEmpresa().getNome();
				}

				@Override
				public String nomeCompletoCliente() {
					return registro.getCliente().getNomeCompleto();
				}

				@Override
				public String nomeCliente() {
					return registro.getCliente().getNome();
				}

				@Override
				public int getUtilizacoes() {
					return registro.getCliente().getUtilizacoes();
				}

				@Override
				public Date getDate() {
					return registro.getDataCadastramento();
				}

				@Override
				public boolean gender() {
					return registro.getCliente().isGender();
				}

				@Override
				public String desconto() {
					if (!registro.isDesconto()) {
						return registro.getCliente().getEmpresa().getDescontoCredito();
					} else {
						return registro.getCliente().getEmpresa().getDescontoAVista();
					}
				}

			};
		} else {
			return null;
		}
	}

}
