package br.com.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jpa.modelo.Conta;

public class TestaRelatorioDasMovimentacoes {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		String jpql = "select c from Conta c";
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		
		List<Conta> contas = query.getResultList();
		for(Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("N�mero: " + conta.getNumero());
			System.out.println("Movimenta��es: " + conta.getMovimentacoes());
		}
		
	}
	
}
