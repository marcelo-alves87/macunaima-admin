package org.macunaima.domain;

import java.util.Date;

public interface RegistroCallback extends Callback {

	String nomeCliente();
	
	String nomeCompletoCliente();
	
	String nomeEmpresa();
	
	String nomeFilial();
	
	int getUtilizacoes();
	
	Date getDate();
	
	boolean gender();
	
	String desconto();
}
