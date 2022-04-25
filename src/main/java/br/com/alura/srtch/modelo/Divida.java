package br.com.alura.srtch.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Divida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long idDivida;

    @Column(nullable=false, length=10)
    private BigDecimal valorDaDivida;

    @Column(nullable=false, length=10)
    private LocalDate dataDeAbertura;

    @Column(length=10)
    private LocalDate dataDeQuitacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private StatusDivida status = StatusDivida.ABERTA;

    @Column(length=255)
    private String descricaoDeQuitacao;

    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    public Divida() {
    }

    public Divida(BigDecimal valorDaDivida, LocalDate dataDeAbertura, StatusDivida status, Cliente cliente) {
        this.valorDaDivida = valorDaDivida;
        this.dataDeAbertura = dataDeAbertura;
        this.status = status;
        this.cliente = cliente;
    }
}
