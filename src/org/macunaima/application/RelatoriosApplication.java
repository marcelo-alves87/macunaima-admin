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

import org.macunaima.domain.Filial;
import org.macunaima.gui.EventListener;
import org.macunaima.service.DefaultService;

public class RelatoriosApplication implements Application {

	public interface RelatoriosDisplay extends Display {

		JButton getImprimirButton();

		JRadioButton getRelatorioFiliaisRadio();

		JRadioButton getRelatorioFilialRadio();

		void put(Vector<Filial> filiais);

		Filial getFilialSelected();

		JComboBox<Filial> getFilaisCombobox();

		void open(String file);
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
				imprimir(relatoriosDisplay.getRelatorioFiliaisRadio().isSelected());
			}
		});
		relatoriosDisplay.getRelatorioFilialRadio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				relatoriosDisplay.getFilaisCombobox().setEnabled(true);

			}
		});
		relatoriosDisplay.getRelatorioFiliaisRadio().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				relatoriosDisplay.getFilaisCombobox().setEnabled(false);

			}
		});
		relatoriosDisplay.put(DefaultService.getFilialController().findAll());

	}

	protected void imprimir(boolean isSelectedRelatorioFilial) {
		if (isSelectedRelatorioFilial) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					String file = DefaultService.getRelatoriosController().printRelatorioFiliais();
					relatoriosDisplay.open(file);
				}
			});

		} else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Filial filial = relatoriosDisplay.getFilialSelected();
					Map<String, String> parameters = new HashMap<String, String>();
					parameters.put("filialID", filial.getId());
					String file = DefaultService.getRelatoriosController().printRelatorioFilial(parameters);
					relatoriosDisplay.open(file);
				}
			});
		}
	}

	@Override
	public void setEventListener(EventListener eventListener) {

	}

}
