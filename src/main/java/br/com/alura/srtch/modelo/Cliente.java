package br.com.alura.srtch.modelo;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @CsvBindByName(column = "CPF", required = true)
  private String cpf;

  @CsvBindByName(required = true)
  private String nome;

  @CsvBindByName(required = true)
  private String profissao;

  @CsvBindByName(required = true)
  private BigDecimal renda;

  private Conta conta;

  private Endereco endereco;

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


  @Override
  public String toString() {
    return "Cliente{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", rua='" + rua + '\'' +
        ", numero='" + numero + '\'' +
        ", complemento='" + complemento + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade='" + cidade + '\'' +
        ", estado='" + estado + '\'' +
        ", profissao='" + profissao + '\'' +
        ", renda=" + renda +
        ", status=" + status +
        '}';
  }
}
