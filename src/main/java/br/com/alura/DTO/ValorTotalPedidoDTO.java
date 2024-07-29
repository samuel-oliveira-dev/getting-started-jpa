package br.com.alura.DTO;

import java.math.BigDecimal;

public class ValorTotalPedidoDTO {
	private long id;
	private BigDecimal valorTotal;
	
	
	
	
	public ValorTotalPedidoDTO(long id, BigDecimal valorTotal) {

		this.id = id;
		this.valorTotal = valorTotal;
	}
	@Override
	public String toString() {
		return "ValorTotalPedidoDTO [id=" + id + ", valorTotal=" + valorTotal + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
