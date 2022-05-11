package br.com.alura.srtch.form;

import br.com.alura.srtch.model.StatusDivida;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DividaForm {

    @NotBlank @Min(1)
    private BigDecimal valor = BigDecimal.ZERO;

    private LocalDate dataDeAbertura;

    private LocalDate dataDeQuitacao;

    private StatusDivida status = StatusDivida.ABERTA;

    private String descricaoDeQuitacao;

    private Long idCliente;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public LocalDate getDataDeQuitacao() {
        return dataDeQuitacao;
    }

    public void setDataDeQuitacao(LocalDate dataDeQuitacao) {
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

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
