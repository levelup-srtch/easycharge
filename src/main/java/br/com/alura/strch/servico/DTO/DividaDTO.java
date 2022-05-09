package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.enuns.StatusDivida;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;



public class DividaDTO implements Serializable{

        private Long id;
        private BigDecimal valor;
        private LocalDate dataAbertura = LocalDate.now();
        private LocalDate dataQuitacao;
        private String descricao;

        @ManyToOne(fetch = FetchType.LAZY)
        private br.com.alura.strch.dominio.Cliente cliente;

        @Enumerated(EnumType.STRING)
        private StatusDivida statusDivida;

    public DividaDTO(BigDecimal valor, LocalDate dataAbertura, LocalDate dataQuitacao, String descricao, Cliente cliente, StatusDivida statusDivida) {
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.dataQuitacao = dataQuitacao;
        this.descricao = descricao;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
    }

    public DividaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public StatusDivida getStatusDivida() {
        return statusDivida;
    }

    public void setStatusDivida(StatusDivida statusDivida) {
        this.statusDivida = statusDivida;
    }
}
