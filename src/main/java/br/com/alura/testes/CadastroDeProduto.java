package br.com.alura.testes;
import java.util.List;

import br.com.alura.DAO.ClienteDAO;
import br.com.alura.DAO.PedidoDAO;
import br.com.alura.DTO.ValorTotalPedidoDTO;
import br.com.alura.modelos.Cliente;


public class CadastroDeProduto {
	public static void main(String args[]) {

		PedidoDAO pedidoDAO = new PedidoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		ValorTotalPedidoDTO valorTotalPedido = pedidoDAO.obterValorTotalPedido(4);
		System.out.print(valorTotalPedido.toString());
		
		List<Cliente> clientes = clienteDAO.obterTodos();
		for(Cliente cliente : clientes){
			System.out.println(cliente.getPedidos().size());
		}
		
		System.out.print(valorTotalPedido.toString());
		
		
	}
}
