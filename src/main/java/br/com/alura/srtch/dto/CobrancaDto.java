package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cobranca;
import br.com.alura.srtch.model.MeioDeContato;
import br.com.alura.srtch.model.TipoAcordo;
import br.com.alura.srtch.model.TipoAgente;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CobrancaDto {

    private Long id;

    private LocalDate dataDeRealizacao;

    private MeioDeContato meioDeContato;

    private String agente;

    private TipoAgente tipoDeAgente;

    private String comentarioDoAgente;

    private String acordo;

    private TipoAcordo tipoDeAcordo;

    private LocalDate dataDePromessaDePagamento;

    private Integer numeroDeParcelas;

    private Long idDivida;

    public CobrancaDto() {
    }

    public CobrancaDto(Cobranca cobranca) {
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
        this.idDivida = cobranca.getDivida().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public MeioDeContato getMeioDeContato() {
        return meioDeContato;
    }

    public String getAgente() {
        return agente;
    }

    public TipoAgente getTipoDeAgente() {
        return tipoDeAgente;
    }

    public String getComentarioDoAgente() {
        return comentarioDoAgente;
    }

    public String getAcordo() {
        return acordo;
    }

    public TipoAcordo getTipoDeAcordo() {
        return tipoDeAcordo;
    }

    public LocalDate getDataDePromessaDePagamento() {
        return dataDePromessaDePagamento;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public Long getIdDivida() {
        return idDivida;
    }

    public static List<CobrancaDto> converter(List<Cobranca> cobrancas) {
        return cobrancas.stream().map(CobrancaDto::new).collect(Collectors.toList());
    }
}
