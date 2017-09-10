package org.macunaima.application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import org.macunaima.domain.Empresa;
import org.macunaima.domain.Filial;
import org.macunaima.gui.EventListener;
import org.macunaima.gui.ui.JDateTextField;
import org.macunaima.service.DefaultService;

public class RelatoriosApplication implements Application {

	public interface RelatoriosDisplay extends Display {

		JButton getImprimirButton();

		JRadioButton getRelatorioEmpresaRadio();

		JRadioButton getRelatorioFilialRadio();

		void putFiliais(Vector<Filial> filiais);

		Filial getFilialSelected();

		JComboBox<Filial> getFilaisCombobox();

		void open(String file);

		void putEmpresas(Vector<Empresa> empresas);

		Empresa getEmpresaSelected();

		JComboBox<Empresa> getEmpresasCombobox();
		
		JDateTextField getDataInicialTextField();
		
		JDateTextField getDataFinalTextField();
	}

	private RelatoriosDisplay relatoriosDisplay;

	@Override
	public Display getDisplay() {
		return relatoriosDisplay;
	}

	@Override
	public void setDisplay(Display display) {
		relatoriosDisplay = (RelatoriosDisplay) display;
		bind();
	}

	private void bind() {
		relatoriosDisplay.getImprimirButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				imprimir(relatoriosDisplay.getRelatorioFilialRadio().isSelected());
			}
		});
		relatoriosDisplay.getRelatorioFilialRadio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				relatoriosDisplay.getEmpresasCombobox().setVisible(false);
				relatoriosDisplay.getFilaisCombobox().setVisible(true);
			}
		});
		relatoriosDisplay.getRelatorioEmpresaRadio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				relatoriosDisplay.getEmpresasCombobox().setVisible(true);
				relatoriosDisplay.getFilaisCombobox().setVisible(false);
			}
		});
		relatoriosDisplay.putFiliais(DefaultService.getFilialController().findAll());
		relatoriosDisplay.putEmpresas(DefaultService.getEmpresaController().findAll());

	}

	protected void imprimir(boolean isSelectedRelatorioFilial) {
		if (isSelectedRelatorioFilial) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Filial filial = relatoriosDisplay.getFilialSelected();
					Map<String, Object> parameters = createDefaultParameters();
					parameters.put("filialID", filial.getId());
					String file = DefaultService.getRelatoriosController().printRelatorioFilial(parameters);
					relatoriosDisplay.open(file);
				}
			});

		} else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Empresa empresa = relatoriosDisplay.getEmpresaSelected();
					Map<String, Object> parameters = createDefaultParameters();
					parameters.put("empresaID", empresa.getId());
					String file = DefaultService.getRelatoriosController().printRelatorioEmpresa(parameters);
					relatoriosDisplay.open(file);
				}
			});
		}
	}

	private Map<String, Object> createDefaultParameters() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("dataInicial", relatoriosDisplay.getDataInicialTextField().getDate());
		parameters.put("dataFinal", relatoriosDisplay.getDataFinalTextField().getDate());
		return parameters;
	}

	@Override
	public void setEventListener(EventListener eventListener) {

	}

}
