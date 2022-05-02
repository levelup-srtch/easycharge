package br.com.alura.srtch.vo;

import java.math.BigDecimal;

public class RelatorioClienteVO {

	private String nomeCliente;
	private BigDecimal totalDividaCliente;
	private Long totalCobrancaCliente;
	
	
	
	
	public RelatorioClienteVO() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public RelatorioClienteVO(String nomeCliente, BigDecimal totalDividaCliente, Long totalCobrancaCliente) {
	
		this.nomeCliente = nomeCliente;
		this.totalDividaCliente = totalDividaCliente;
		this.totalCobrancaCliente = totalCobrancaCliente;
	}

	public RelatorioClienteVO(String nomeCliente) {
		
		this.nomeCliente = nomeCliente;
	
	}

	public RelatorioClienteVO(String nomeCliente, BigDecimal totalDividaCliente) {
		
		this.nomeCliente = nomeCliente;
		this.totalDividaCliente = totalDividaCliente;
	}
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public BigDecimal getTotalDividaCliente() {
		return totalDividaCliente;
	}
	public void setTotalDividaCliente(BigDecimal totalDividaCliente) {
		this.totalDividaCliente = totalDividaCliente;
	}
	public Long getTotalCobrancaCliente() {
		return totalCobrancaCliente;
	}
	public void setTotalCobrancaCliente(Long totalCobrancaCliente) {
		this.totalCobrancaCliente = totalCobrancaCliente;
	}




	@Override
	public String toString() {
		return "RelatorioClienteVO [Nome Cliente = " + nomeCliente + ", Total Divida Cliente = " + totalDividaCliente
				+ ", Total Cobranca Cliente = " + totalCobrancaCliente + "]";
	}

	
	
	
}
