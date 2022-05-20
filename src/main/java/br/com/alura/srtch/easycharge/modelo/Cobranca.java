package br.com.alura.srtch.easycharge.modelo;

import java.util.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cobranca")
public class Cobranca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 
	@Column(length=50,nullable=false) 
	private Date dataDeRealizacao;
	
	@Enumerated(EnumType.STRING)
	@Column(length=100,nullable=false)
	private MeioDeContato meioDeContato;
	
	@Column(length=100,nullable=false)
	private String agente;
	
	@Enumerated(EnumType.STRING)
	@Column(length=100,nullable=false)
	private TipoDeAgente tipoDeAgente;
	
	@Column(length=500,nullable=false)
	private String comentarioDoAgente;
	
	@Column(length=500,nullable=false)
	private String acordo;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20,nullable=false)
	private TipoDeAcordo tipoDeAcordo;
	
	@Column(length=50,nullable=true) 
	private Date dataDePromessaDePagamento;
 	
	@Column(length=12,nullable=true)
	private int numeroDeParcelas;
 	
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(nullable = false)
	 private Divida divida;

	
	 
	
	
	public Cobranca() {
		
		// TODO Auto-generated constructor stub
	}
	
	

	public Cobranca(Date dataDeRealizacao, MeioDeContato meioDeContato, String agente,
			TipoDeAgente tipoDeAgente, String comentarioDoAgente, String acordo, TipoDeAcordo tipoDeAcordo,
			Date dataDePromessaDePagamento, int numeroDeParcelas, Divida divida) {
		
		
		this.dataDeRealizacao = dataDeRealizacao;
		this.meioDeContato = meioDeContato;
		this.agente = agente;
		this.tipoDeAgente = tipoDeAgente;
		this.comentarioDoAgente = comentarioDoAgente;
		this.acordo = acordo;
		this.tipoDeAcordo = tipoDeAcordo;
		this.dataDePromessaDePagamento = dataDePromessaDePagamento;
		this.numeroDeParcelas = numeroDeParcelas;
		this.divida = divida;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDeRealizacao() {
		return dataDeRealizacao;
	}

	public void setDataDeRealizacao(Date dataDeRealizacao) {
		this.dataDeRealizacao = dataDeRealizacao;
	}

	public MeioDeContato getMeioDeContato() {
		return meioDeContato;
	}

	public void setMeioDeContato(MeioDeContato meioDeContato) {
		this.meioDeContato = meioDeContato;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public TipoDeAgente getTipoDeAgente() {
		return tipoDeAgente;
	}

	public void setTipoDeAgente(TipoDeAgente tipoDeAgente) {
		this.tipoDeAgente = tipoDeAgente;
	}

	public String getComentarioDoAgente() {
		return comentarioDoAgente;
	}

	public void setComentarioDoAgente(String comentarioDoAgente) {
		this.comentarioDoAgente = comentarioDoAgente;
	}

	public String getAcordo() {
		return acordo;
	}

	public void setAcordo(String acordo) {
		this.acordo = acordo;
	}

	public TipoDeAcordo getTipoDeAcordo() {
		return tipoDeAcordo;
	}

	public void setTipoDeAcordo(TipoDeAcordo tipoDeAcordo) {
		this.tipoDeAcordo = tipoDeAcordo;
	}

	public Date getDataDePromessaDePagamento() {
		return dataDePromessaDePagamento;
	}

	public void setDataDePromessaDePagamento(Date dataDePromessaDePagamento) {
		this.dataDePromessaDePagamento = dataDePromessaDePagamento;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Divida getDivida() {
		return divida;
	}

	public void setDivida(Divida divida) {
		this.divida = divida;
	}

	public Cobranca(Long id){
        this.id = id;
    }


	@Override
	public String toString() {
		return "Cobranca [getId()=" + getId() + ", getDataDeRealizacao()=" + getDataDeRealizacao()
				+ ", getMeioDeContato()=" + getMeioDeContato() + ", getAgente()=" + getAgente() + ", getTipoDeAgente()="
				+ getTipoDeAgente() + ", getComentarioDoAgente()=" + getComentarioDoAgente() + ", getAcordo()="
				+ getAcordo() + ", getTipoDeAcordo()=" + getTipoDeAcordo() + ", getDataDePromessaDePagamento()="
				+ getDataDePromessaDePagamento() + ", getNumeroDeParcelas()=" + getNumeroDeParcelas() + ", getDivida()="
				+ getDivida() + "]";
	}
	
	
	
}
