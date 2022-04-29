package br.com.alura.srtch.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "divida")
public class Divida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=100,nullable=false)
	private BigDecimal valorDaDivida;
	 
	@Column(length=50,nullable=false) 
	private Date dataDeAbertura;
	 	
	@Column(length=50,nullable=true)
	private Date dataDeQuitacao;
	
	@Column(length=20,nullable=false)
	private StatusDivida status;
 	
	@Column(length=500,nullable=true)
	private String descricaoDeQuitacao;
 	

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente", referencedColumnName = "id")
	//@Column(length=255,nullable=false)
	
	@OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobrancas = new ArrayList<>();
	
	private Cliente cliente;
	

 	
 	
 	
	public Divida() {
		
		
	}
	
	public Divida(BigDecimal valorDaDivida, Date dataDeAbertura, Date dataDeQuitacao, StatusDivida status,
			String descricaoDeQuitacao, Cliente cliente) {
		
		this.valorDaDivida = valorDaDivida;
		this.dataDeAbertura = dataDeAbertura;
		this.dataDeQuitacao = dataDeQuitacao;
		this.status = status;
		this.descricaoDeQuitacao = descricaoDeQuitacao;
		this.cliente = cliente;
	}
	public BigDecimal getValorDaDivida() {
		return valorDaDivida;
	}
	public void setValorDaDivida(BigDecimal valorDaDivida) {
		this.valorDaDivida = valorDaDivida;
	}
	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}
	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	public Date getDataDeQuitacao() {
		return dataDeQuitacao;
	}
	public void setDataDeQuitacao(Date dataDeQuitacao) {
		this.dataDeQuitacao = dataDeQuitacao;
	}
	public StatusDivida getStatus() {
		return status;
	}
	public void setStatus(StatusDivida status) {
		this.status = status;
	}
	public String getDescricaoDeQuitacao() {
		return descricaoDeQuitacao;
	}
	public void setDescricaoDeQuitacao(String descricaoDeQuitacao) {
		this.descricaoDeQuitacao = descricaoDeQuitacao;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	


	  
		  

	@Override
	public String toString() {
		return "Divida [getValorDaDivida()=" + getValorDaDivida() + ", getDataDeAbertura()=" + getDataDeAbertura()
				+ ", getDataDeQuitacao()=" + getDataDeQuitacao() + ", getStatus()=" + getStatus()
				+ ", getDescricaoDeQuitacao()=" + getDescricaoDeQuitacao() + ", getCliente()=" + getCliente() + "]";
	}
	
	  
}
