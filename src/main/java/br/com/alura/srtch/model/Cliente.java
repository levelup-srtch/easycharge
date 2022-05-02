package br.com.alura.srtch.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(length=10)
  private Long id;

  @Column(nullable=false, length=10)
  private BigDecimal renda;

  private BigDecimal limiteDivida;

  @Embedded
  private DadosPessoais dadosPessoais;

  @Embedded
  private Endereco endereco;

  @Enumerated(EnumType.STRING)
  @JoinColumn(nullable = false)
  private StatusCliente status = StatusCliente.ATIVO;

  public Cliente() {
  }

  public Cliente(BigDecimal renda, DadosPessoais dadosPessoais, Endereco endereco) {
    this.renda = renda;
    this.dadosPessoais = dadosPessoais;
    this.endereco = endereco;
  }

  public void setLimiteDeDivida(){
      this.limiteDivida = this.renda.multiply(BigDecimal.valueOf(12));
  }

  public Long getId() {
    return id;
  }

  public BigDecimal getRenda() {
    return renda;
  }

  public void setRenda(BigDecimal renda) {
    this.renda = renda;
  }

  public BigDecimal getLimiteDivida() {
    return limiteDivida;
  }

  public DadosPessoais getDadosPessoais() {
    return dadosPessoais;
  }

  public void setDadosPessoais(DadosPessoais dadosPessoais) {
    this.dadosPessoais = dadosPessoais;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public StatusCliente getStatus() {
    return status;
  }

  public void setStatus(StatusCliente status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "renda=" + renda +
            ", dadosPessoais=" + dadosPessoais +
            ", endereco=" + endereco +
            ", status=" + status +
            '}';
  }
}
