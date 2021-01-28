package br.com.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.jpa.modelo.Categoria;
import br.com.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		
		@SuppressWarnings("deprecation")
		Categoria categoria = new Categoria();
		categoria.setId(1L);
		
		TypedQuery<Movimentacao> query = em.createQuery(sql, Movimentacao.class);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Categorias: " + movimentacao.getCategorias());
			System.out.println("Descricao: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
	}
}
