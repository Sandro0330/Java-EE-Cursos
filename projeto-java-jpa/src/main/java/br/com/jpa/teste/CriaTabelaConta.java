package br.com.jpa.teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaTabelaConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		emf.close();
	}
}
