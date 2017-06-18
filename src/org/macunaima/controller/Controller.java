package org.macunaima.controller;

import java.util.Vector;

import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;

public interface Controller<T extends Entity> {

	Callback persist(T entity);

	Callback delete(Entity entity);

	Vector<T> findAll();
	
	T findById(String id);

	Vector<T> find(String search);

}
