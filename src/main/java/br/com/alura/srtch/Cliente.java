package br.com.alura.srtch;

import com.opencsv.bean.CsvBindByName;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
  @CsvBindByName
  @Column(name = "nome",length=255,nullable=false)
  private String nome;

  @CsvBindByName
  @Column(name = "cpf",length=20,nullable=false)
  private String cpf;

  @CsvBindByName
  @Column(name = "telefone",length=50,nullable=false)
  private String telefone;

  @CsvBindByName
  @Column(name = "email",length=100,nullable=false)
  private String email;

  @CsvBindByName
  @Column(name = "rua",length=255,nullable=false)
  private String rua;

  @CsvBindByName
  @Column(name = "numero",length=30,nullable=false)
  private String numero;

  @CsvBindByName
  @Column(name = "complemento",length=255,nullable=true)
  private String complemento;

  @CsvBindByName
  @Column(name = "bairro",length=100,nullable=false)
  private String bairro;

  @CsvBindByName
  @Column(name = "cidade",length=200,nullable=false)
  private String cidade;

  @CsvBindByName
  @Column(name = "estado",length=60,nullable=false)
  private String estado;

  @CsvBindByName
  @Column(name = "profissao",length=100,nullable=false)
  private String profissao;

  @CsvBindByName
  @Column(name = "renda",length=200,nullable=false)
  private BigDecimal renda;

  @CsvBindByName
  @Column(name = "status",length=20,nullable=false)
  private StatusCliente status;

  public Cliente() {
		
	}
  

	public Cliente( String nome, String cpf, String telefone, String email, String rua, String numero,
		String complemento, String bairro, String cidade, String estado, String profissao, BigDecimal renda,
		StatusCliente status) {
		
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.email = email;
	this.rua = rua;
	this.numero = numero;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cidade = cidade;
	this.estado = estado;
	this.profissao = profissao;
	this.renda = renda;
	this.status = status;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
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
