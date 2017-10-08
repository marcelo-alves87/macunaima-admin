package org.macunaima.controller;

import org.macunaima.domain.Cliente;

public interface ClienteController extends Controller<Cliente> {

	Cliente findDigital(String input);

	void incrementarUtilizacoes(Cliente cliente);

	Cliente findCodigoLocalizador(String codigoLocalizador);

}
