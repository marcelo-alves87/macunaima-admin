package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.macunaima.controller.Controller;
import org.macunaima.domain.Entity;
import org.macunaima.gui.EventListener;

public abstract class AbstractListApplication<T extends Entity> implements Application {

	public interface ListDisplay<T extends Entity> extends Display {

		JButton getSearchButton();

		JTextField getSearch();

		void put(Vector<T> entities);

		JTable getJTable();

		JButton goToNewEntity();
	}

	private ListDisplay<T> listDisplay;
	private EventListener eventListener;

	@Override
	public Display getDisplay() {
		return listDisplay;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setDisplay(Display display) {
		this.listDisplay = (ListDisplay<T>) display;
		bind();
	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;

	}

	protected EventListener getEventListener() {
		return this.eventListener;
	}

	private void bind() {
		this.listDisplay.getSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				find();

			}
		});

		this.listDisplay.getSearch().requestFocus();

		this.listDisplay.getSearchButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						find();
					}

				});

			}
		});

		this.listDisplay.getJTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent me) {
				Point p = me.getPoint();
				int row = listDisplay.getJTable().rowAtPoint(p);
				if (me.getClickCount() == 2) {
					goToEntity(row);
				}
			}

		});
		this.listDisplay.goToNewEntity().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goToNewEntity();

			}
		});
	}

	protected abstract void goToEntity(int row);

	protected abstract void goToNewEntity();

	protected abstract Controller<T> getController();

	private void find() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vector<T> entities = getController().find(listDisplay.getSearch().getText());
					listDisplay.put(entities);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected ListDisplay<T> getListDisplay() {
		return this.listDisplay;
	}
}
