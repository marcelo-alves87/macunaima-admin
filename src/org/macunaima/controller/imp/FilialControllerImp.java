package org.macunaima.controller.imp;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.macunaima.controller.FilialController;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;
import org.macunaima.domain.Filial;

import com.mongodb.DBCollection;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

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

	@Override
	public Callback persist(Filial entity) {
		checkConnection();
		if (!entity.isNew()) {
			deleteLogo(entity);
		}
		String logoName = persistLogotipo(entity);
		entity.setLogoName(logoName);
		return super.persist(entity);
	}

	private String persistLogotipo(Filial entity) {
		String logoName = UUID.randomUUID().toString();
		File imageFile = entity.getLogotipo();
		getCollection("images");
		GridFS gfsPhoto = new GridFS(getDefaultDB(), "photo");
		try {
			GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
			gfsFile.setFilename(logoName);
			gfsFile.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logoName;
	}

	@Override
	public Callback delete(Entity entity) {
		deleteLogo(entity);
		return super.delete(entity);
	}

	private void deleteLogo(Entity entity) {
		Filial filial = findById(entity.getId());
		GridFS gfsPhoto = new GridFS(getDefaultDB(), "photo");
		GridFSDBFile imageForOutput = gfsPhoto.findOne(filial.getLogoName());
		gfsPhoto.remove(imageForOutput);
	}

	@Override
	public Filial findById(String id) {
		Filial filial = super.findById(id);
		GridFS gfsPhoto = new GridFS(getDefaultDB(), "photo");
		GridFSDBFile imageForOutput = gfsPhoto.findOne(filial.getLogoName());
		File file = new File("file");
		try {
			imageForOutput.writeTo(file);
		} catch (Exception e) {
		}
		filial.setLogotipo(file);
		return filial;
	}

}
