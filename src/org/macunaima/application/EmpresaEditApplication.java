package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.macunaima.domain.Callback;
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

		void showMessage(String string);

		boolean confirmSalvarEmpresa();

		boolean confirmDeletarEmpresa();

	}

	private EmpresaDisplay display;
	private Empresa empresa;
	private EventListener eventListener;

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
				close();

			}
		});

		display.getSalvarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (display.confirmSalvarEmpresa()) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							persist();
						}
					});
				}
			}
		});

		display.getCancelarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();

			}
		});

		display.getDeletarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (display.confirmDeletarEmpresa()) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							delete();
						}
					});
				}

			}
		});

	}

	protected void close() {
		eventListener.closeEditEmpresa();

	}

	protected void persist() {
		Empresa empresa = new Empresa();
		if (this.empresa != null) {
			empresa.setId(this.empresa.getId());
		}
		display.copyTo(empresa);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Callback callback = DefaultService.getEmpresaController().persist(empresa);
				processPersist(callback);
			}
		});

	}

	protected void processPersist(Callback callback) {
		if (callback.callBack() == 1) {
			display.showMessage("Empresa salva com sucesso!");
			close();
		}

	}

	protected void delete() {
		Empresa empresa = new Empresa();
		if (this.empresa != null) {
			empresa.setId(this.empresa.getId());
		}
		display.copyTo(empresa);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Callback callback = DefaultService.getEmpresaController().delete(empresa);
				processDelete(callback);
			}
		});
	}

	protected void processDelete(Callback callback) {
		if (callback.callBack() == 0) {
			display.showMessage("N�o foi poss�vel deletar a empresa");
		} else if (callback.callBack() == 1) {
			display.showMessage("Empresa removida com sucesso!");
			close();
		}

	}

	@Override
	public void setEventListener(EventListener eventListener) {
		this.eventListener = eventListener;
	}
}
