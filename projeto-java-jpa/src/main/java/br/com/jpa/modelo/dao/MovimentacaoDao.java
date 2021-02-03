package br.com.jpa.modelo.dao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class MovimentacaoDao {
	
	private	EntityManager em;
	
	
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public BigDecimal getSomaDasMovimentacoes()  {
		String jpql = "select sum(m.valor) from Movimentacao m";
		
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		BigDecimal somadasMovimenacoes = query.getSingleResult();
		
		return somadasMovimenacoes;
	}
}
