package br.com.alura.DAO;

import br.com.alura.Util.JPAUtil;
import br.com.alura.modelos.ItemPedido;

public class ItemPedidoDAO extends AbstractDAO<ItemPedido> {
	
	public ItemPedidoDAO() {
		super(JPAUtil.getEntityManager(), ItemPedido.class);
	}

}
