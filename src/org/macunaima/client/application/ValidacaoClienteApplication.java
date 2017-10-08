package org.macunaima.client.application;

import org.macunaima.domain.Cliente;

public interface ValidacaoClienteApplication {

	int getMesDataNascimentoCliente(Cliente cliente);

	void getValidacaoClienteActionListener(Cliente cliente);
}
