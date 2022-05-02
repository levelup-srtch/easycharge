package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> transformarEmCliente(List<ClienteDTO> clientesDoArquivo){
        DadosPessoais dadosPessoais;
        Endereco endereco;
        for(ClienteDTO cda : clientesDoArquivo){
            dadosPessoais = new DadosPessoais(cda.getCpf(), cda.getNome(), cda.getProfissao(), cda.getTelefone(), cda.getEmail());
            endereco = new Endereco(cda.getRua(), cda.getNumero(), cda.getBairro(), cda.getCidade(), cda.getEstado());
            if(cda.getComplemento() != null){
                endereco.setComplemento(cda.getComplemento());
            }
            this.clientes.add(new Cliente(cda.getRenda(), dadosPessoais, endereco));
        }
        return clientes;
    }

}
