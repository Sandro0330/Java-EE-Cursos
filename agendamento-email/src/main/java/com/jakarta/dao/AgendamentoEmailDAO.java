package com.jakarta.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.jakarta.entidade.AgendamentoEmail;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AgendamentoEmailDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private UserTransaction transaction;
	
	public List<AgendamentoEmail> listar() {
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae", AgendamentoEmail.class).getResultList();
	}
	
	public void inserir(AgendamentoEmail agendamentoEmail) {
		entityManager.persist(agendamentoEmail);
		

	}
	
	public List<AgendamentoEmail> listarPorNaoAgendado() {
		return entityManager.createQuery("SELECT ae FROM AgendamentoEmail ae WHERE ae.agendado = false", AgendamentoEmail.class).getResultList();		
	}
	
	public void alterar(AgendamentoEmail agendamentoEmail) {
		try {
			transaction.begin();
			entityManager.merge(agendamentoEmail);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
