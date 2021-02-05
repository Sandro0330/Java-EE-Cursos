package com.jakarta.job;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

import com.jakarta.entidade.AgendamentoEmail;
import com.jakarta.servico.AgendamentoEmailServico;

@Singleton
public class AgendamentoEmailJob {

	@Inject 
	private AgendamentoEmailServico agendamentoEmailServico;
	
	@Inject
	@JMSConnectionFactory("java:jboss/DefaultJMSConnectionFactory")
	private JMSContext context;
	
	 @Resource(mappedName = "java:/jms/queue/EmailQueue")
	 private Queue queue;
	
	@Schedule(hour = "*", minute = "*", second = "*/10")
	public void enviarEmail() { 
		List<AgendamentoEmail> listarPorNaoAgendado = agendamentoEmailServico.listarPronaoAgendado();
		listarPorNaoAgendado.forEach(emailNaoAgendado -> {
			context.createProducer().send(queue, emailNaoAgendado);
			agendamentoEmailServico.alterar(emailNaoAgendado);
		});
	}
}
