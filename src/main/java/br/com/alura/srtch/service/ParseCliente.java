package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cadastro;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Endereco;
import br.com.alura.srtch.modelo.RecebeClienteDoArquivo;

import java.util.ArrayList;
import java.util.List;

public class ParseCliente {

    public List<Cliente> transformarEmCliente(List<RecebeClienteDoArquivo> rcdas){
        List<Cliente> clientes = new ArrayList<>();
        Cadastro cadastro;
        Endereco endereco;
        for(RecebeClienteDoArquivo rcda : rcdas){
            cadastro = new Cadastro(rcda.getTelefone(), rcda.getEmail(), rcda.getStatus());
            endereco = new Endereco(rcda.getRua(), rcda.getNumero(), rcda.getBairro(), rcda.getCidade(), rcda.getEstado());
            if(!rcda.getComplemento().isEmpty()){
                endereco.setComplemento(rcda.getComplemento());
            }
            Cliente cliente = new Cliente(rcda.getCpf(), rcda.getNome(), rcda.getProfissao(), rcda.getRenda(), cadastro, endereco);
            clientes.add(cliente);
        }
        return clientes;
    }

}
