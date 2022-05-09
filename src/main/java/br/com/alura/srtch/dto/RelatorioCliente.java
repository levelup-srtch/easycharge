package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RelatorioCliente {

    private String nome;
    private String CPF;
    private String telefone;
    private String cidade;
    private String estado;
    private BigDecimal renda;
    private StatusCliente status;

    public RelatorioCliente(Cliente cliente) {
        this.nome = cliente.getDadosPessoais().getNome();
        this.CPF = cliente.getDadosPessoais().getCpf();
        this.telefone = cliente.getDadosPessoais().getTelefone();
        this.cidade = cliente.getEndereco().getCidade();
        this.estado = cliente.getEndereco().getEstado();
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

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public static List<RelatorioCliente> converter(List<Cliente> clientes){
        return clientes.stream().map(RelatorioCliente::new).collect(Collectors.toList());
    }
}
