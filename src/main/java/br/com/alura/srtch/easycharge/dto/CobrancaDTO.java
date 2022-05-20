package br.com.alura.srtch.easycharge.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.srtch.easycharge.modelo.Cobranca;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.modelo.MeioDeContato;
import br.com.alura.srtch.easycharge.modelo.TipoDeAcordo;
import br.com.alura.srtch.easycharge.modelo.TipoDeAgente;

public class CobrancaDTO {

	private Long id;
	
	private Date dataDeRealizacao;
	
	private MeioDeContato meioDeContato;
	
	private String agente;
	
	private TipoDeAgente tipoDeAgente;
	
	private String comentarioDoAgente;
	
	private String acordo;

	private TipoDeAcordo tipoDeAcordo;

	private Date dataDePromessaDePagamento;
 	
	private int numeroDeParcelas;

	private Long idDivida ;

	public CobrancaDTO() {

	}

	
	
	
	public CobrancaDTO(Cobranca cobranca) {
		
		this.id = cobranca.getId();
		this.dataDeRealizacao = cobranca.getDataDeRealizacao();
		this.meioDeContato = cobranca.getMeioDeContato();
		this.agente = cobranca.getAgente();
		this.tipoDeAgente = cobranca.getTipoDeAgente();
		this.comentarioDoAgente = cobranca.getComentarioDoAgente();
		this.acordo = cobranca.getAcordo();
		this.tipoDeAcordo = cobranca.getTipoDeAcordo();
		this.dataDePromessaDePagamento = cobranca.getDataDePromessaDePagamento();
		this.numeroDeParcelas = cobranca.getNumeroDeParcelas();
		this.idDivida =   cobranca.getDivida().getId();
	}
	

	public Long getId() {
		return id;
	}

	public Date getDataDeRealizacao() {
		return dataDeRealizacao;
	}

	public MeioDeContato getMeioDeContato() {
		return meioDeContato;
	}

	public String getAgente() {
		return agente;
	}

	public TipoDeAgente getTipoDeAgente() {
		return tipoDeAgente;
	}

	public String getComentarioDoAgente() {
		return comentarioDoAgente;
	}

	public String getAcordo() {
		return acordo;
	}

	public TipoDeAcordo getTipoDeAcordo() {
		return tipoDeAcordo;
	}

	public Date getDataDePromessaDePagamento() {
		return dataDePromessaDePagamento;
	}

	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public Long getDivida() {
		return idDivida;
	}

	@Override
	public String toString() {
		return "CobrancaDTO [id=" + id + ", dataDeRealizacao=" + dataDeRealizacao + ", meioDeContato=" + meioDeContato
				+ ", agente=" + agente + ", tipoDeAgente=" + tipoDeAgente + ", comentarioDoAgente=" + comentarioDoAgente
				+ ", acordo=" + acordo + ", tipoDeAcordo=" + tipoDeAcordo + ", dataDePromessaDePagamento="
				+ dataDePromessaDePagamento + ", numeroDeParcelas=" + numeroDeParcelas + ", idDivida=" + idDivida + "]";
	}
	
	

	public static List<CobrancaDTO> converte(List<Cobranca> cobrancas) {
		return cobrancas.stream().map(CobrancaDTO::new).collect(Collectors.toList());
	}
	
	
}
