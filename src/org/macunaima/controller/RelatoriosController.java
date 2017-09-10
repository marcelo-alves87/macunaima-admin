package org.macunaima.controller;

import java.util.Map;

public interface RelatoriosController {
	
	String printRelatorioFilial(Map<String, Object> parameters);
	
	String printRelatorioEmpresa(Map<String, Object> parameters);

}
