package br.com.alura.srtch.dto;

import br.com.alura.srtch.modelo.DadosPessoais;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ObjetoCliente {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> transformarEmCliente(List<ClienteDoArquivo> rcdas){
        DadosPessoais cadastro;
        Endereco endereco;
        for(ClienteDoArquivo cda : rcdas){
            cadastro = new DadosPessoais(cda.getTelefone(), cda.getEmail(), cda.getStatus());
            endereco = new Endereco(cda.getRua(), cda.getNumero(), cda.getBairro(), cda.getCidade(), cda.getEstado());
            if(cda.getComplemento() != null){
                endereco.setComplemento(cda.getComplemento());
            }
            this.clientes.add(new Cliente(cda.getCpf(), cda.getNome(), cda.getProfissao(), cda.getRenda(), cadastro, endereco));
        }
        return clientes;
    }

}
