package org.macunaima.controller;

import java.util.Vector;

import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;

public interface Controller<T extends Entity> {

	Callback persist(T entity);

	Callback delete(T entity);

	Vector<T> find(String... search);

	Vector<T> findAll();

}
