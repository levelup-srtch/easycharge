package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

import java.math.BigDecimal;

public class ClientesResponseDto {

    private final String nome;
    private final String CPF;
    private final String telefone;
    private final String local;
    private final BigDecimal renda;
    private final StatusCliente status;

    public ClientesResponseDto(Cliente cliente) {
        this.nome = cliente.getDadosPessoais().getNome();
        this.CPF = cliente.getDadosPessoais().getCpf();
        this.telefone = cliente.getDadosPessoais().getTelefone();
        this.local = cliente.getEndereco().getCidade()+ "/" +cliente.getEndereco().getEstado();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
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

}
