package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ClienteDTO {

    private final Long id;

    private final String nome;

    private final String cpf;

    private final String telefone;

    private final String email;

    private final String rua;

    private final String numero;

    private final String complemento;

    private final String bairro;

    private final String cidade;

    private final String estado;

    private final String profissao;

    private final BigDecimal renda;

    private final StatusCliente status;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.rua = cliente.getRua();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade();
        this.estado = cliente.getEstado();
        this.profissao = cliente.getProfissao();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
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
}
