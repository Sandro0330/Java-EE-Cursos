package br.com.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class AlteraSaldoConta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
	
		Conta alterandoConta = em.find(Conta.class , 1L);
	
		System.out.println("Acessando a conta do " + alterandoConta.getTitular());
		
		em.getTransaction().begin();
		alterandoConta.setSaldo(20.0);
		em.getTransaction().commit();
	}
	
}
