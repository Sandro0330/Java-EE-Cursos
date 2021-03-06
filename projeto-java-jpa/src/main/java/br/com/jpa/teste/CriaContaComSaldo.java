package br.com.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jpa.modelo.Conta;

public class CriaContaComSaldo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Leandro");
		conta.setNumero(1256);
		conta.setAgencia(1376);
		conta.setSaldo(300.0);
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da conta da Marcio: " + conta.getId());
		conta.setSaldo(800.0);
		
		em2.getTransaction().begin();
		em2.merge(conta);
		em2.getTransaction().commit();
	}
}
