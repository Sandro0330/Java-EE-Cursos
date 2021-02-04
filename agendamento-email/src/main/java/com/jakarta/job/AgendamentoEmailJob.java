package com.jakarta.job;

import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.jakarta.entidade.AgendamentoEmail;
import com.jakarta.servico.AgendamentoEmailServico;

@Singleton
public class AgendamentoEmailJob {

	@Inject 
	private AgendamentoEmailServico agendamentoEmailServico;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail() { 
		List<AgendamentoEmail> listarPorNaoAgendado = agendamentoEmailServico.listarPronaoAgendado();
		listarPorNaoAgendado.forEach(emailNaoAgendado -> {
			agendamentoEmailServico.enviar(emailNaoAgendado);
			agendamentoEmailServico.alterar(emailNaoAgendado);
		});
	}
}
