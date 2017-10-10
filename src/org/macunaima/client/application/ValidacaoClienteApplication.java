package org.macunaima.client.application;

import java.util.List;

import org.macunaima.domain.Cliente;

public interface ValidacaoClienteApplication {

	int getMesDataNascimentoCliente(Cliente cliente);

	void getValidacaoClienteActionListener(Cliente cliente, Integer month);
	
	Integer getRandomMonth(List<Integer> meses);

}
