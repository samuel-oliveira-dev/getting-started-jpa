package br.com.alura.DAO;
import java.math.BigDecimal;
import java.util.List;

import br.com.alura.Util.JPAUtil;
import br.com.alura.modelos.Produto;


public class ProdutoDAO extends AbstractDAO<Produto>{
	
	
	public ProdutoDAO() {
		super(JPAUtil.getEntityManager(), Produto.class);
	}
	
	public List<Produto> obterPorNome(String nome) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p from Produto p ")
		  .append("WHERE p.nome = :nome");
		
		return this.entityManager.createQuery(sb.toString(), Produto.class)
				   .setParameter("nome", nome)
				   .getResultList();
	}
	
	public List<Produto> obterPorCategoriaId(long idCategoria){
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p FROM Produto p ")
		  .append("JOIN p.categoria ")
		  .append("WHERE p.categoria.id = :idCategoria");
		
		return this.entityManager.createQuery(sb.toString(), Produto.class)
				   .setParameter("idCategoria", idCategoria)
			       .getResultList();
	}
	
	public BigDecimal obterPrecoProdutoPorId(long id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p.preco FROM Produto p ");
		sb.append("WHERE p.id = :id");
		
		return this.entityManager.createQuery(sb.toString(), BigDecimal.class)
				.setParameter("id", id)
				.getSingleResult();
		
	}
	

}
