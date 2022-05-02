package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.dominio.enuns.FormaDeCobraca;
import br.com.alura.strch.dominio.enuns.TipoDeAcordo;
import br.com.alura.strch.dominio.enuns.TipoDeAgente;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cobrancas")
public class CobrancaDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaCobranca;

    @Enumerated(EnumType.STRING)
    private FormaDeCobraca formaDeCobraca;

    private String agente;

    @Enumerated(EnumType.STRING)
    private TipoDeAgente tipoDeAgente;

    private String comentarioAgente;

    private String descricaoDoAcordo;

    private TipoDeAcordo tipoDeAcordo;

    private LocalDate dataPromessaPagmento;

    private Integer numeroDeParcela;

    @ManyToOne(fetch = FetchType.LAZY)
    private Divida divida;

    public CobrancaDTO() {
    }

    public CobrancaDTO(LocalDate dataDaCobranca, FormaDeCobraca formaDeCobraca, String agente, TipoDeAgente tipoDeAgente, String comentarioAgente, String descricaoDoAcordo, TipoDeAcordo tipoDeAcordo, LocalDate dataPromessaPagmento, Integer numeroDeParcela, Divida divida) {
        this.dataDaCobranca = dataDaCobranca;
        this.formaDeCobraca = formaDeCobraca;
        this.agente = agente;
        this.tipoDeAgente = tipoDeAgente;
        this.comentarioAgente = comentarioAgente;
        this.descricaoDoAcordo = descricaoDoAcordo;
        this.tipoDeAcordo = tipoDeAcordo;
        this.dataPromessaPagmento = dataPromessaPagmento;
        this.numeroDeParcela = numeroDeParcela;
        this.divida = divida;
    }

    public LocalDate getDataDaCobranca() {
        return dataDaCobranca;
    }

    public void setDataDaCobranca(LocalDate dataDaCobranca) {
        this.dataDaCobranca = dataDaCobranca;
    }

    public FormaDeCobraca getFormaDeCobraca() {
        return formaDeCobraca;
    }

    public void setFormaDeCobraca(FormaDeCobraca formaDeCobraca) {
        this.formaDeCobraca = formaDeCobraca;
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

    public String getComentarioAgente() {
        return comentarioAgente;
    }

    public void setComentarioAgente(String comentarioAgente) {
        this.comentarioAgente = comentarioAgente;
    }

    public String getDescricaoDoAcordo() {
        return descricaoDoAcordo;
    }

    public void setDescricaoDoAcordo(String descricaoDoAcordo) {
        this.descricaoDoAcordo = descricaoDoAcordo;
    }

    public TipoDeAcordo getTipoDeAcordo() {
        return tipoDeAcordo;
    }

    public void setTipoDeAcordo(TipoDeAcordo tipoDeAcordo) {
        this.tipoDeAcordo = tipoDeAcordo;
    }

    public LocalDate getDataPromessaPagmento() {
        return dataPromessaPagmento;
    }

    public void setDataPromessaPagmento(LocalDate dataPromessaPagmento) {
        this.dataPromessaPagmento = dataPromessaPagmento;
    }

    public Integer getNumeroDeParcela() {
        return numeroDeParcela;
    }

    public void setNumeroDeParcela(Integer numeroDeParcela) {
        this.numeroDeParcela = numeroDeParcela;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }
}
