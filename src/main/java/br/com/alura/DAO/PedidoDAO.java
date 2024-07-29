package br.com.alura.DAO;

import br.com.alura.DTO.ValorTotalPedidoDTO;
import br.com.alura.Util.JPAUtil;
import br.com.alura.modelos.Pedido;

public class PedidoDAO extends AbstractDAO<Pedido>{
	public PedidoDAO() {
		super(JPAUtil.getEntityManager(), Pedido.class);
	}
	
	public ValorTotalPedidoDTO obterValorTotalPedido(long idPedido) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT new ")
		  .append(ValorTotalPedidoDTO.class.getName() +" (ip.pedido.id as id, SUM(ip.quantidade * ip.precoUnitario) as valorTotal) ")
		  .append("FROM ItemPedido ip ")
		  .append("WHERE ip.pedido.id = :idPedido ")
		  .append("GROUP BY ip.pedido.id ");
		
		return this.entityManager.createQuery(sb.toString(), ValorTotalPedidoDTO.class)
				.setParameter("idPedido", idPedido)
				.getSingleResult();
	}
}
