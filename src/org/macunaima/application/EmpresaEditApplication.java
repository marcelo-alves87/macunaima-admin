package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.macunaima.domain.Empresa;
import org.macunaima.gui.EventListener;
import org.macunaima.service.DefaultService;

public class EmpresaEditApplication implements Application {

	public interface EmpresaDisplay extends Display {

		JButton getSalvarButton();

		JButton getCancelarButton();

		JButton getDeletarButton();

		void copyFrom(Empresa empresa);

		void copyTo(Empresa empresa);

		void close();

	}

	private EmpresaDisplay display;
	private Empresa empresa;

	public EmpresaEditApplication() {
		super();
	}

	public EmpresaEditApplication(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public Display getDisplay() {
		return display;
	}

	@Override
	public void setDisplay(Display display) {
		this.display = (EmpresaDisplay) display;
		bind();
		if (this.empresa != null) {
			this.display.copyFrom(empresa);
		}

	}

	private void bind() {
		display.getCancelarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				display.close();

			}
		});

		display.getSalvarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						persist();
					}
				});
			}
		});

		display.getCancelarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				display.close();

			}
		});

		display.getDeletarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						delete();
					}
				});

			}
		});

	}

	protected void persist() {
		Empresa empresa = new Empresa();
		if (this.empresa != null) {
			empresa.setId(this.empresa.getId());
		}
		display.copyTo(empresa);
		DefaultService.getEmpresaController().persist(empresa);
	}

	protected void delete() {

	}

	@Override
	public void setEventListener(EventListener eventListener) {
		// TODO Auto-generated method stub
	}
}
