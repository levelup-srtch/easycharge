package br.com.alura.srtch.easycharge.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.modelo.StatusCliente;

public class ClienteDTO {

	   private Long id;
	 
	   private String nome;
	   
	   private String cpf;
	  
	   private String telefone;
	  
	   private String local;
	 
	   private BigDecimal renda;
	
	   private StatusCliente  status;
	   
/*
	public ClienteDTO(Long id, String nome, String cpf, String telefone, String local, BigDecimal renda,
			StatusCliente status) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.local = local;
		this.renda = renda;
		this.status = status;
	} 
	
	*/
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.local =  cliente.getEndereco().getCidade() + "/" +  cliente.getEndereco().getEstado();
		this.renda = cliente.getRenda();
		this.status = cliente.getStatus();
	}


	@Override
	public String toString() {
		return "ClienteDTO [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", local=" + local + ", renda="
				+ renda + ", status=" + status + "]";
	}


	public Long getId() {
		return id;
	}




	public String getNome() {
		return nome;
	}




	public String getCpf() {
		return cpf;
	}


	

	public String getTelefone() {
		return telefone;
	}


	

	public String getLocal() {
		return local;
	}



	public BigDecimal getRenda() {
		return renda;
	}


	

	public StatusCliente getStatus() {
		return status;
	}


	public static List<ClienteDTO> converte(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}
	
	   
	   
}


