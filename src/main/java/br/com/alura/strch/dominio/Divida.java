package br.com.alura.strch.dominio;

import br.com.alura.strch.dominio.enuns.StatusDivida;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "dividas")
public class Divida implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDate dataAbertura = LocalDate.now();
    private LocalDate dataQuitacao;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private StatusDivida statusDivida;

    public Divida(BigDecimal valor, LocalDate dataAbertura, Cliente cliente, StatusDivida statusDivida, String descricao) {
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
        this.descricao = descricao;
    }

    public Divida() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Divida(BigDecimal valor) {
        this.valor = valor;
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
