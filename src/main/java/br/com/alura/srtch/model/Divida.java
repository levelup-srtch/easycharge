package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divida")
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long id;

    @Column(nullable=false)
    private BigDecimal valor = BigDecimal.ZERO;

    @Column(nullable=false)
    private LocalDate dataDeAbertura;

    private LocalDate dataDeQuitacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusDivida status = StatusDivida.ABERTA;

    @Column(length=255)
    private String descricaoDeQuitacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "divida", cascade = CascadeType.ALL)
    private final List<Cobranca> cobrancas = new ArrayList<>();

    public Divida() {
    }

    public Divida(BigDecimal valorDaDivida,StatusDivida status, Cliente cliente) {
        this.valor = valorDaDivida;
        this.dataDeAbertura = LocalDate.now();
        this.status = status;
        this.cliente = cliente;
    }

    public void adicionarCobranca(Cobranca cobranca){
        cobranca.setDivida(this);
        this.cobrancas.add(cobranca);
    }

    public long getId() {
        return id;
    }

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cobranca> getCobrancas() {
        return cobrancas;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "valorDaDivida=" + valor +
                ", dataDeAbertura=" + dataDeAbertura +
                ", status=" + status +
                ", cliente=" + cliente +
                ", cobrancas=" + cobrancas +
                '}';
    }
}
