package br.com.alura.srtch.easycharge.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.modelo.Endereco;
import br.com.alura.srtch.easycharge.modelo.StatusCliente;

public class RequisicaoNovoCliente {
	  
	   private Long id;
	   @NotBlank
	   private String nome;
	   @NotBlank
	   private String cpf;
	   @NotBlank
	   private String telefone;
	   @NotBlank
	   private String email;
	   @NotBlank
	   private String rua;
	   @NotBlank
	   private String numero;
	   private String complemento;
	   @NotBlank
	   private String bairro;
	   @NotBlank
	   private String cidade;
	   @NotBlank
	   private String estado;
	   @NotBlank
	   private String profissao;
	   @NotNull
	   @Min (1)
	   private BigDecimal renda;
	  // @Pattern(regexp = "^ATIVO$|^SUSPENSO$")
	   private StatusCliente  status;

	   //aula 5 bin validation nos atributos
	   
	   public String getNome() {
	        return nome;
	    }
	   
	   
	   public String getCpf() {
	        return cpf;
	    }
	   
	   
	   public String getTelefone() {
	        return telefone;
	    }
	   
	   
	   public String getEmail() {
	        return email;
	    }
	   
	   
	   public String getRua() {
	        return rua;
	    }
	   
	   
	   public String getNumero() {
	        return numero;
	    }
	   
	 
	   public String getComplemento() {
	        return complemento;
	    }
	   
	   
	   public String getBairro() {
	        return bairro;
	    }
	   
	   
	   public String getCidade() {
	        return cidade;
	    }
	   
	   
	   public String getEstado() {
	        return estado;
	    }

	   
	   public String getProfissao() {
	        return profissao;
	    }

	   
	   public BigDecimal getRenda() {
	        return renda;
	    }

	   
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
	
	public  Cliente editar (Cliente cliente, RequisicaoNovoCliente clienteDTO){
		//cliente.setId(id);
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		//cliente.setEndereco(new Endereco(rua, numero, complemento, bairro, cidade, estado)); funciona mas cria endereços novos
		cliente.getEndereco().setCidade(cidade);
		cliente.getEndereco().setBairro(bairro);
		cliente.getEndereco().setComplemento(complemento);
		cliente.getEndereco().setEstado(estado);
		cliente.getEndereco().setNumero(numero);
		cliente.getEndereco().setRua(rua);

		cliente.setProfissao(profissao);
		cliente.setRenda(renda);
		cliente.setStatus(status);
		return cliente;
		
	}
	
}
