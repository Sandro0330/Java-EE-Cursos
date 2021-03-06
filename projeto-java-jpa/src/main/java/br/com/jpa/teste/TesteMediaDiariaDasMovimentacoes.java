package br.com.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select avg(m.valor), day(m.data), month(m.data) from Movimentacao m group by day(m.data), month(m.data), year(m.data)";
		
		Query query = em.createQuery(jpql);
		List<Object[]> mediaDasMovimenacoes = query.getResultList();
		
		for(Object[]  resultado : mediaDasMovimenacoes) {
			
			System.out.println("A m�dia das movimenta��es do dia " + resultado[1] + "/ " + resultado[2] + " �: " + resultado[0]);
		}  		
	}
}
