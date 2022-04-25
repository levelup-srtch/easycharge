package br.com.alura.srtch.modelo;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @CsvBindByName(required = true)
  @Column(nullable=false, length=14)
  private String cpf;

  @CsvBindByName(required = true)
  @Column(nullable=false, length=100)
  private String nome;

  @CsvBindByName(required = true)
  @Column(nullable=false, length=50)
  private String profissao;

  @CsvBindByName(required = true)
  @Column(nullable=false, length=10)
  private BigDecimal renda;

  private BigDecimal limiteDivida;

  @OneToOne
  @JoinColumn(nullable = false)
  private Cadastro cadastro;

  @OneToOne
  @JoinColumn(nullable = false)
  private Endereco endereco;

  public Cliente() {
  }

  public Cliente(String cpf, String nome, String profissao, BigDecimal renda, Cadastro cadastro, Endereco endereco) {
    this.cpf = cpf;
    this.nome = nome;
    this.profissao = profissao;
    this.renda = renda;
    this.cadastro = cadastro;
    this.endereco = endereco;
  }

  public void setLimiteDeDivida(){
      this.limiteDivida = this.renda.multiply(BigDecimal.valueOf(12));
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getProfissao() {
    return profissao;
  }

  public void setProfissao(String profissao) {
    this.profissao = profissao;
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

  public Cadastro getCadastro() {
    return cadastro;
  }

  public void setCadastro(Cadastro conta) {
    this.cadastro = conta;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  @Override
  public String toString() {
    return "Cliente{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", telefone='" + cadastro.getTelefone() + '\'' +
            ", email='" + cadastro.getEmail() + '\'' +
            ", rua='" + endereco.getRua() + '\'' +
            ", numero='" + endereco.getNumero() + '\'' +
            ", complemento='" + endereco.getComplemento() + '\'' +
            ", bairro='" + endereco.getBairro() + '\'' +
            ", cidade='" + endereco.getCidade() + '\'' +
            ", estado='" + endereco.getEstado() + '\'' +
            ", profissao='" + profissao + '\'' +
            ", renda=" + renda +
            ", status=" + cadastro.getStatus() +
            '}';
  }
}
