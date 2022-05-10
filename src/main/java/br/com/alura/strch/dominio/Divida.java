package br.com.alura.strch.dominio;

import br.com.alura.strch.dominio.enuns.StatusDivida;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "dividas")
public class Divida implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public Divida() {
    }
    public Divida(BigDecimal valor, LocalDate dataAbertura, Cliente cliente, StatusDivida statusDivida, String descricao) {
        this.valor = valor;
        this.dataAbertura = dataAbertura;
        this.cliente = cliente;
        this.statusDivida = statusDivida;
        this.descricao = descricao;
    }
}
