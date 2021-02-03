package com.jakarta.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jakarta.entidade.AgendamentoEmail;

@Stateless
public class AgendamentoEmailDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<AgendamentoEmail> listar() {
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
		

	}
}
