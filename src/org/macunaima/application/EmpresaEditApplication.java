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

		JButton getDeletarButton();

		void copyFrom(Empresa empresa);

		void copyTo(Empresa empresa);

		void showMessage(String string);

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
		display.getSalvarButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						if (validate()) {
							persist();
						}
					}
				});
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

	protected boolean validate() {
		boolean isValid = true;
		Empresa empresa = importEmpresaFromDisplay();
		if (empresa.getNome() == null || empresa.getNome().isEmpty()) {
			isValid = false;
			display.showMessage("Por favor, insira um nome da empresa");
		} else if (empresa.getDescontoCredito() == null || empresa.getDescontoCredito().isEmpty()) {
			isValid = false;
			display.showMessage("Por favor, insira um valor de desconto a crédito");
		} else if (empresa.getDescontoAVista() == null || empresa.getDescontoAVista().isEmpty()) {
			isValid = false;
			display.showMessage("Por favor, insira um valor de desconto à vista");
		}
		return isValid;
	}

	private Empresa importEmpresaFromDisplay() {
		Empresa empresa = new Empresa();
		if (this.empresa != null) {
			empresa.setId(this.empresa.getId());
		}
		display.copyTo(empresa);
		return empresa;
	}

	protected void close() {
		eventListener.closeEditEmpresa();

	}

	protected void persist() {
		Empresa empresa = importEmpresaFromDisplay();
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
		Empresa empresa = importEmpresaFromDisplay();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Callback callback = DefaultService.getEmpresaController().delete(empresa);
				processDelete(callback);
			}
		});
	}

	protected void processDelete(Callback callback) {
		if (callback.callBack() == 0) {
			display.showMessage("Não foi possível deletar a empresa");
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
