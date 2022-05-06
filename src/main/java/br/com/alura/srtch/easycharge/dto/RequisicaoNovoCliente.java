package br.com.alura.srtch.easycharge.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.modelo.Endereco;
import br.com.alura.srtch.easycharge.modelo.StatusCliente;

public class RequisicaoNovoCliente {
	   private Long id;
	   private String nome;
	   private String cpf;
	   private String telefone;
	   private String email; 
	   private String rua;
	   private String numero;
	   private String complemento;	  
	   private String bairro;    
	   private String cidade;
	   private String estado;
	   private String profissao;
	   private BigDecimal renda;
	   private StatusCliente  status;

	   @NotBlank
	   public String getNome() {
	        return nome;
	    }
	   
	   @NotBlank
	   public String getCpf() {
	        return cpf;
	    }
	   
	   @NotBlank
	   public String getTelefone() {
	        return telefone;
	    }
	   
	   @NotBlank
	   public String getEmail() {
	        return email;
	    }
	   
	   @NotBlank
	   public String getRua() {
	        return rua;
	    }
	   
	   @NotBlank
	   public String getNumero() {
	        return numero;
	    }
	   
	 
	   public String getComplemento() {
	        return complemento;
	    }
	   
	   @NotBlank
	   public String getBairro() {
	        return bairro;
	    }
	   
	   @NotBlank
	   public String getCidade() {
	        return cidade;
	    }
	   
	   @NotBlank
	   public String getEstado() {
	        return estado;
	    }

	   @NotBlank
	   public String getProfissao() {
	        return profissao;
	    }

	   @NotNull
	   public BigDecimal getRenda() {
	        return renda;
	    }

	   @NotNull
	   public StatusCliente getStatus() {
	        return status;
	    }
	   

	   public void setNome(String nome) {
	        this.nome = nome;
	    }

	   public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }

	   public void setTelefone(String telefone) {
	        this.telefone = telefone;
	    }

	   public void setEmail(String email) {
	        this.email = email;
	    }

	   public void setRua(String rua) {
	        this.rua = rua;
	    }

	   public void setNumero(String numero) {
	        this.numero = numero;
	    }

	   public void setComplemento(String complemento) {
	        this.complemento = complemento;
	    }

	   public void setBairro(String bairro) {
	        this.bairro = bairro;
	    }

	   public Long getId() {
	        return id;
	    }

	   public void setId(Long id) {
	        this.id = id;
	    }

	   public void setCidade(String cidade) {
	        this.cidade = cidade;
	    }

	   public void setEstado(String estado) {
	        this.estado = estado;
	    }

	   public void setProfissao(String profissao) {
	        this.profissao = profissao;
	    }

	   public void setRenda(BigDecimal renda) {
	        this.renda = renda;
	    }

	   public void setStatus(StatusCliente status) {
		    this.status = status;
		  }

	public Cliente toCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setEndereco(new Endereco(rua, numero, complemento, bairro, cidade, estado));
		cliente.setProfissao(profissao);
		cliente.setRenda(renda);
		cliente.setStatus(status);
		
		return cliente;
	}
	
}
