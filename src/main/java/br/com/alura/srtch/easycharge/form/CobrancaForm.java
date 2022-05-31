package br.com.alura.srtch.easycharge.form;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.Length;

import br.com.alura.srtch.easycharge.modelo.Cobranca;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.modelo.MeioDeContato;
import br.com.alura.srtch.easycharge.modelo.TipoDeAcordo;
import br.com.alura.srtch.easycharge.modelo.TipoDeAgente;

public class CobrancaForm {


	@PastOrPresent
	private Date dataDeRealizacao;
	
	
	private MeioDeContato meioDeContato;
	
	@NotBlank
	private String agente;
	
	@NotNull
	private TipoDeAgente tipoDeAgente;
	
	@NotBlank @Length(max = 500)
	private String comentarioDoAgente;
	
	@Length(max = 500)
	private String acordo;
	
	
	private TipoDeAcordo tipoDeAcordo;

	@Future
	private Date dataDePromessaDePagamento;
 	
	@Min(1)@Max(12)
	private int numeroDeParcelas;
	
	
	private Long idDivida ;

	public CobrancaForm() {

	}

	/*
	public CobrancaForm(Date dataDeRealizacao, MeioDeContato meioDeContato, String agente,
			TipoDeAgente tipoDeAgente, String comentarioDoAgente, String acordo, TipoDeAcordo tipoDeAcordo,
			Date dataDePromessaDePagamento, int numeroDeParcelas, Long idDivida) {
		
		
		this.dataDeRealizacao = dataDeRealizacao;
		this.meioDeContato = meioDeContato;
		this.agente = agente;
		this.tipoDeAgente = tipoDeAgente;
		this.comentarioDoAgente = comentarioDoAgente;
		this.acordo = acordo;
		this.tipoDeAcordo = tipoDeAcordo;
		this.dataDePromessaDePagamento = dataDePromessaDePagamento;
		this.numeroDeParcelas = numeroDeParcelas;
		this.idDivida = idDivida;
	}
	*/
	
	public CobrancaForm(Cobranca cobranca) {
		
	
		this.dataDeRealizacao = getDataDeRealizacao();
		this.meioDeContato = getMeioDeContato();
		this.agente = getAgente();
		this.tipoDeAgente = getTipoDeAgente();
		this.comentarioDoAgente = getComentarioDoAgente();
		this.acordo = getAcordo();
		this.tipoDeAcordo = getTipoDeAcordo();
		this.dataDePromessaDePagamento = getDataDePromessaDePagamento();
		this.numeroDeParcelas = getNumeroDeParcelas();
		this.idDivida = cobranca.getDivida().getId();
	}
	
	public Cobranca toCobranca() {
		Divida divida = new Divida(idDivida);
		Cobranca cobranca = new Cobranca();
		cobranca.setDivida(divida);
		cobranca.setAcordo(acordo);
		cobranca.setAgente(agente);
		cobranca.setComentarioDoAgente(comentarioDoAgente);
		cobranca.setDataDePromessaDePagamento(dataDePromessaDePagamento);
		cobranca.setDataDeRealizacao(dataDeRealizacao);
		cobranca.setMeioDeContato(meioDeContato);
		cobranca.setNumeroDeParcelas(numeroDeParcelas);
		cobranca.setTipoDeAcordo(tipoDeAcordo);
		cobranca.setTipoDeAgente(tipoDeAgente);
		
		return cobranca;
		
		
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

	public Long getIdDivida() {
		return idDivida;
	}
	
	
	

	public void setDataDeRealizacao(Date dataDeRealizacao) {
		this.dataDeRealizacao = dataDeRealizacao;
	}

	public void setMeioDeContato(MeioDeContato meioDeContato) {
		this.meioDeContato = meioDeContato;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public void setTipoDeAgente(TipoDeAgente tipoDeAgente) {
		this.tipoDeAgente = tipoDeAgente;
	}

	public void setComentarioDoAgente(String comentarioDoAgente) {
		this.comentarioDoAgente = comentarioDoAgente;
	}

	public void setAcordo(String acordo) {
		this.acordo = acordo;
	}

	public void setTipoDeAcordo(TipoDeAcordo tipoDeAcordo) {
		this.tipoDeAcordo = tipoDeAcordo;
	}

	public void setDataDePromessaDePagamento(Date dataDePromessaDePagamento) {
		this.dataDePromessaDePagamento = dataDePromessaDePagamento;
	}

	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public void setIdDivida(Long idDivida) {
		this.idDivida = idDivida;
	}

	@Override
	public String toString() {
		return "CobrancaDTO [dataDeRealizacao=" + dataDeRealizacao + ", meioDeContato=" + meioDeContato
				+ ", agente=" + agente + ", tipoDeAgente=" + tipoDeAgente + ", comentarioDoAgente=" + comentarioDoAgente
				+ ", acordo=" + acordo + ", tipoDeAcordo=" + tipoDeAcordo + ", dataDePromessaDePagamento="
				+ dataDePromessaDePagamento + ", numeroDeParcelas=" + numeroDeParcelas + ", idDivida=" + idDivida + "]";
	}
	
	
}