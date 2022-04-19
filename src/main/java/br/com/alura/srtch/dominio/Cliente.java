package br.com.alura.srtch.dominio;

import br.com.alura.srtch.dominio.enuns.StatusCliente;
import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class Cliente extends Endereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CsvBindByName
  private String nome;

  @CsvBindByName
  private String cpf;

  @CsvBindByName
  private String telefone;

  @CsvBindByName
  private String email;

  @CsvBindByName
  private String profissao;

  @CsvBindByName
  private BigDecimal renda;

  @CsvBindByName
  private StatusCliente status;

  @ManyToOne
  @JoinColumn(name = "id_endereco")
  private Endereco endereco;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public StatusCliente getStatus() {
    return status;
  }

  public void setStatus(StatusCliente status) {
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", rua='" +getRua() + '\'' +
        ", numero='" + getNumero() + '\'' +
        ", complemento='" + getComplemento() + '\'' +
        ", bairro='" + getBairro() + '\'' +
        ", cidade='" + getCidade() + '\'' +
        ", estado='" + getEstado() + '\'' +
        ", profissao='" + profissao + '\'' +
        ", renda=" + renda +
        ", status=" + status +
        '}';
  }
}
