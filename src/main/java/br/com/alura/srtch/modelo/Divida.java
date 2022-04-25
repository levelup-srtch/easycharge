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

    @ManyToOne
    private Cliente cliente;



}
