package br.com.alura.srtch.easycharge.modelo;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(namespace = "clientes")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
  @XmlElement	
  @Column(name = "nome",length=255,nullable=false)
  private String nome;


  @Column(name = "cpf",length=20,nullable=false)
  private String cpf;

  @Column(name = "telefone",length=50,nullable=false)
  private String telefone;


  @Column(name = "email",length=100,nullable=false)
  private String email;


  @Column(name = "profissao",length=100,nullable=false)
  private String profissao;


  @Column(name = "renda",length=200,nullable=false)
  private BigDecimal renda;


  @Enumerated(EnumType.STRING)
  @Column(name = "status",length=20,nullable=false)
  private StatusCliente status;


  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "endereco", referencedColumnName = "id_endereco")
  private Endereco endereco;
  
  public Cliente() {
		
	}
  

	public Cliente( String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda,
		StatusCliente status, Endereco endereco) {
		
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.email = email;

	this.profissao = profissao;
	this.renda = renda;
	this.status = status;
	this.endereco = endereco;
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
  
	public Endereco getEndereco() {
		return endereco;
	}

	/*
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	*/

  @Override
  public String toString() {
    return "Cliente{" +
        "nome='" + nome + '\'' +
        ", cpf='" + cpf + '\'' +
        ", telefone='" + telefone + '\'' +
        ", email='" + email + '\'' +
        ", rua='" + getEndereco().getRua() + '\'' +
        ", numero='" + getEndereco().getNumero() + '\'' +
        ", complemento='" + getEndereco().getComplemento() + '\'' +
        ", bairro='" + getEndereco().getBairro() + '\'' +
        ", cidade='" + getEndereco().getCidade() + '\'' +
        ", estado='" + getEndereco().getEstado() + '\'' +
        ", profissao='" + profissao + '\'' +
        ", renda=" + renda +
        ", status=" + status +
        '}';
  }
}
