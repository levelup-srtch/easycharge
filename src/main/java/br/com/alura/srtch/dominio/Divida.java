package br.com.alura.srtch.dominio;

import java.time.LocalDate;

public class Divida {

    private Long Valor;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataQuitacao;

    public Divida(Long valor) {
        Valor = valor;
    }

    public Divida() {
    }

    public Long getValor() {
        return Valor;
    }

    public void setValor(Long valor) {
        Valor = valor;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataQuitacao() {
        return dataQuitacao;
    }

    public void setDataQuitacao(LocalDate dataQuitacao) {
        this.dataQuitacao = dataQuitacao;
    }
}
