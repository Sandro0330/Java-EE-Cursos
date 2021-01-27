package br.com.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriaConta {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta= new Conta();
		conta.setTitular("Sandro");
		conta.setNumero(2487);
		conta.setAgencia(3567);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
	}

}
