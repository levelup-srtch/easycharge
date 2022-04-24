package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cadastro;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Endereco;
import br.com.alura.srtch.modelo.RecebeClienteDoArquivo;

import java.util.ArrayList;
import java.util.List;

public class ParseCliente {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> transformarEmCliente(List<RecebeClienteDoArquivo> rcdas){
        Cadastro cadastro;
        Endereco endereco;
        for(RecebeClienteDoArquivo cda : rcdas){
            cadastro = new Cadastro(cda.getTelefone(), cda.getEmail(), cda.getStatus());
            endereco = new Endereco(cda.getRua(), cda.getNumero(), cda.getBairro(), cda.getCidade(), cda.getEstado());
            if(cda.getComplemento() != null){
                endereco.setComplemento(cda.getComplemento());
            }
            this.clientes.add(new Cliente(cda.getCpf(), cda.getNome(), cda.getProfissao(), cda.getRenda(), cadastro, endereco));
        }
        return clientes;
    }

}
