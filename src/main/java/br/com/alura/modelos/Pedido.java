package br.com.alura.modelos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido extends AbstractModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	private LocalDate data =  LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	
	
	public Pedido() {
		
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		itemPedido.setPedido(this);
		this.itens.add(itemPedido);
	}
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getData() {
		return data; 
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	
}
