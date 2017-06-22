package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Callback;
import org.macunaima.domain.Entity;
import org.macunaima.gui.EventListener;

public abstract class AbstractEditApplication<T extends Entity> implements Application {

	public interface EditDisplay<T extends Entity> extends Display {

		JButton getSalvarButton();

		JButton getDeletarButton();

		void copyFrom(T entity);

		void copyTo(T entity);

		void showMessage(String string);

		boolean confirmDeletar();

	}

	private EditDisplay<T> editDisplay;
	private EventListener eventListener;
	private T entity;

	public AbstractEditApplication() {
		super();
	}

	public AbstractEditApplication(T entity) {
		this.entity = entity;
	}

	@Override
	public Display getDisplay() {
		return editDisplay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setDisplay(Display display) {
		this.editDisplay = (EditDisplay<T>) display;
		bind();
		fetchFirst();
		fetch();
		if (this.entity != null) {
			this.editDisplay.copyFrom(this.entity);
		}
	}

	protected void fetchFirst() {

	}

	private void fetch() {
		if (this.entity != null) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						entity = getController().findById(entity.getId());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;

	}

	protected EventListener getEventListener() {
		return this.eventListener;
	}

	protected void bind() {
		this.editDisplay.getSalvarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				persist();
			}
		});

		this.editDisplay.getDeletarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (editDisplay.confirmDeletar()) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							delete();
						}
					});
				}

			}
		});

	}

	protected abstract boolean validate();

	protected T importFromDisplay() {
		Class<T> clazz = getInstance();
		T newEntity = null;
		try {
			newEntity = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (this.entity != null) {
			newEntity.setId(this.entity.getId());
		}
		editDisplay.copyTo(newEntity);
		return newEntity;
	}

	protected abstract Class<T> getInstance();

	protected abstract void close();

	protected abstract Controller<T> getController();

	protected void persist() {
		T entity = importFromDisplay();
		if (validate()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Callback callback = getController().persist(entity);
					processPersist(callback);
				}
			});
		}

	}

	protected void processPersist(Callback callback) {
		if (callback.callBack() == 1) {
			this.editDisplay.showMessage(getSucessPersistMessage());
			close();
		}

	}

	protected abstract String getSucessPersistMessage();

	protected void delete() {
		T entity = importFromDisplay();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Callback callback = getController().delete(entity);
				processDelete(callback);
			}
		});
	}

	protected void processDelete(Callback callback) {
		if (callback.callBack() == 0) {
			editDisplay.showMessage(getErrorDeleteMessage());
		} else if (callback.callBack() == 1) {
			editDisplay.showMessage(getSucessDeleteMessage());
			close();
		}

	}

	protected abstract String getSucessDeleteMessage();

	protected abstract String getErrorDeleteMessage();

	protected void showMessage(String string) {
		this.editDisplay.showMessage(string);
	}
}
