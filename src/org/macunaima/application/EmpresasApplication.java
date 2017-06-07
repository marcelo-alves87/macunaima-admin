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

import org.macunaima.domain.Empresa;
import org.macunaima.gui.EventListener;
import org.macunaima.service.DefaultService;

public class EmpresasApplication implements Application {

	public interface EmpresasDisplay extends Display {

		JButton getSearchButton();

		String getSearchText();

		void put(Vector<Empresa> empresas);

		JTable getJTable();
		
		JButton goToNewEmpresa();
	}

	private EmpresasDisplay display;
	private EventListener eventListener;

	@Override
	public Display getDisplay() {
		return display;
	}

	@Override
	public void setDisplay(Display display) {
		this.display = (EmpresasDisplay) display;
		bind();

	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;
	}

	private void bind() {
		this.display.getSearchButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						Vector<Empresa> empresas = DefaultService.getEmpresaController().find(display.getSearchText());
						display.put(empresas);
					}
				});

			}
		});

		this.display.getJTable().addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent me) {
				Point p = me.getPoint();
				int row = display.getJTable().rowAtPoint(p);
				if (me.getClickCount() == 2) {
					Empresa empresa = convertToEmpresa(row);
					eventListener.goToEditEmpresa(empresa);
				}
			}

		});
		display.goToNewEmpresa().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				goToNewEmpresa();
				
			}
		});

	}

	protected void goToNewEmpresa() {
		this.eventListener.goToEditEmpresa(null);
		
	}

	protected Empresa convertToEmpresa(int row) {
		Empresa empresa = new Empresa();
		empresa.setId((String) display.getJTable().getModel().getValueAt(row, 3));
		empresa.setNome((String) display.getJTable().getModel().getValueAt(row, 0));
		empresa.setDescontoCredito((String) display.getJTable().getModel().getValueAt(row, 1));
		empresa.setDescontoAVista((String) display.getJTable().getModel().getValueAt(row, 2));
		return empresa;
	}

}
