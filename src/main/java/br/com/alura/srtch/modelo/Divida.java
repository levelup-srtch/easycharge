package br.com.alura.srtch.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "divida")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long idDivida;

    @Column(nullable=false, length=50)
    private BigDecimal valorDaDivida = BigDecimal.ZERO;

    @Column(nullable=false, length=10)
    private LocalDate dataDeAbertura;

    @Column(length=10)
    private LocalDate dataDeQuitacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusDivida status = StatusDivida.ABERTA;

    @Column(length=255)
    private String descricaoDeQuitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Cliente cliente;

    public Divida() {
    }

    public Divida(BigDecimal valorDaDivida,StatusDivida status, Cliente cliente) {
        this.valorDaDivida = valorDaDivida;
        this.dataDeAbertura = LocalDate.now();
        this.status = status;
        this.cliente = cliente;
    }

    public long getIdDivida() {
        return idDivida;
    }

    public BigDecimal getValorDaDivida() {
        return valorDaDivida;
    }

    public void setValorDaDivida(BigDecimal valorDaDivida) {
        this.valorDaDivida = valorDaDivida;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "valorDaDivida=" + valorDaDivida +
                ", dataDeAbertura=" + dataDeAbertura +
                ", status=" + status +
                ", cliente=" + cliente +
                '}';
    }
}
