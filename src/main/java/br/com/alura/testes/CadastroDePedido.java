package br.com.alura.testes;

import br.com.alura.DAO.ClienteDAO;
import br.com.alura.DAO.ItemPedidoDAO;
import br.com.alura.DAO.PedidoDAO;
import br.com.alura.DAO.ProdutoDAO;
import br.com.alura.modelos.Cliente;
import br.com.alura.modelos.ItemPedido;
import br.com.alura.modelos.Pedido;
import br.com.alura.modelos.Produto;

public class CadastroDePedido {

	public static void main(String[] args) {
	
		
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		PedidoDAO  pedidoDAO = new PedidoDAO();
		
		Cliente cliente = new Cliente("Fluano de Tal", "456456");
		clienteDAO.cadastrar(cliente);
		
		//Cliente cliente = clienteDAO.obterPorId(1);
		Produto produto = produtoDAO.obterPorId(6);
		
		
		Pedido pedido = new Pedido(cliente);
		
		ItemPedido itemPedido = new ItemPedido(4, pedido, produto);
		pedido.adicionarItem(itemPedido);
		pedidoDAO.cadastrar(pedido);
		
		
		
		
	}

}
