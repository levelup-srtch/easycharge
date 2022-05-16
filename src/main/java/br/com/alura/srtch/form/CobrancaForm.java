package br.com.alura.srtch.form;

import br.com.alura.srtch.model.MeioDeContato;
import br.com.alura.srtch.model.TipoAcordo;
import br.com.alura.srtch.model.TipoAgente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class CobrancaForm {

    @NotNull @PastOrPresent
    private LocalDate dataDeRealizacao;

    @NotNull
    private MeioDeContato meioDeContato;

    @NotBlank
    private String agente;

    @NotNull
    private TipoAgente tipoDeAgente;

    @NotNull @Length(max = 500)
    private String comentarioDoAgente;

    @Length(max = 500)
    private String acordo;

    private TipoAcordo tipoDeAcordo;

    @Future
    private LocalDate dataDePromessaDePagamento;

    @Min(1)@Max(12)
    private Integer numeroDeParcelas;

    @NotNull
    private Long idDivida;

    public LocalDate getDataDeRealizacao() {
        return dataDeRealizacao;
    }

    public void setDataDeRealizacao(LocalDate dataDeRealizacao) {
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

    public TipoAgente getTipoDeAgente() {
        return tipoDeAgente;
    }

    public void setTipoDeAgente(TipoAgente tipoDeAgente) {
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

    public TipoAcordo getTipoDeAcordo() {
        return tipoDeAcordo;
    }

    public void setTipoDeAcordo(TipoAcordo tipoDeAcordo) {
        this.tipoDeAcordo = tipoDeAcordo;
    }

    public LocalDate getDataDePromessaDePagamento() {
        return dataDePromessaDePagamento;
    }

    public void setDataDePromessaDePagamento(LocalDate dataDePromessaDePagamento) {
        this.dataDePromessaDePagamento = dataDePromessaDePagamento;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Long getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(Long idDivida) {
        this.idDivida = idDivida;
    }
}
