package com.jakarta.servico;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailServico {
	
	public List<String> listar() {
		return List.of("joao@gamil.com.br");
	}

}
