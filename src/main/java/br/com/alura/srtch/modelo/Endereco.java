package br.com.alura.srtch.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

@Entity
 // se usar esse parametro @Embeddable não se utiliza o @entity, geralmente usado quando atributos da classe que nao tem tabela estão em outra classe, exemplo classe dados pessoais
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id_endereco;
	

  @CsvBindByName
  @Column(name = "rua",length=255,nullable=false)
  private String rua;

  @CsvBindByName
  @Column(name = "numero",length=30,nullable=false)
  private String numero;

  @CsvBindByName
  @Column(name = "complemento",length=255,nullable=false)
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

  	public Endereco() {
	};

	public Endereco(  String rua, String numero,
		String complemento, String bairro, String cidade, String estado) {
		

	this.rua = rua;
	this.numero = numero;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cidade = cidade;
	this.estado = estado;

}

	public Long getId() {
		return id_endereco;
	}

	public void setId(Long id_endereco) {
		this.id_endereco = id_endereco;
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

 
  

  @Override
  public String toString() {
    return "Endereco{" +
        ", rua='" + rua + '\'' +
        ", numero='" + numero + '\'' +
        ", complemento='" + complemento + '\'' +
        ", bairro='" + bairro + '\'' +
        ", cidade='" + cidade + '\'' +
        ", estado='" + estado + '\'' +
        '}';
  }
}
