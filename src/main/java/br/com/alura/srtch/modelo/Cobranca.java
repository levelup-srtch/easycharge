package br.com.alura.srtch.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long idCobranca;

    @Column(nullable=false, length=10)
    private LocalDate dataDeRealizacao = LocalDate.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Contato meioDeContato;

    @Column(nullable=false, length=50)
    private String agente;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private TipoAgente tipoDeAgente;

    @Column(nullable=false, length=500)
    private String comentarioDoAgente;

    @Column(length=500)
    private String acordo;

    @Enumerated(EnumType.STRING)
    private TipoAcordo tipoDeAcordo;

    @Column(length=10)
    private LocalDate dataDePromessaDePagamento;

    @Column(length=2)
    private Integer numeroDeParcelas;

    @OneToOne
    @JoinColumn(nullable = false)
    private Divida divida;

    public Cobranca() {
    }

    public Cobranca(Contato meioDeContato, String agente, TipoAgente tipoDeAgente, String comentarioDoAgente, Divida divida) {
        this.meioDeContato = meioDeContato;
        this.agente = agente;
        this.tipoDeAgente = tipoDeAgente;
        this.comentarioDoAgente = comentarioDoAgente;
        this.divida = divida;
    }
}
