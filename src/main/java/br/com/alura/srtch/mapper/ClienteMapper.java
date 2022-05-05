package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public List<Cliente> cadastrar(List<ClienteDTO> clientesDTO) {
        List<Cliente> clientes = new ArrayList<>();
        DadosPessoais dadosPessoais;
        Endereco endereco;
        StatusCliente statusCliente = StatusCliente.ATIVO;
        for (ClienteDTO cda : clientesDTO) {
            dadosPessoais = new DadosPessoais(cda.getCpf(), cda.getNome(), cda.getProfissao(), cda.getTelefone(), cda.getEmail());
            endereco = new Endereco(cda.getRua(), cda.getNumero(), cda.getBairro(), cda.getCidade(), cda.getEstado());
            if (cda.getComplemento() != null) {
                endereco.setComplemento(cda.getComplemento());
            }
            if (cda.getStatus().equals("SUSPENSO")) {
                statusCliente = StatusCliente.SUSPENSO;
            }
            clientes.add(new Cliente(cda.getRenda(), dadosPessoais, endereco, statusCliente));
        }
        return clientes;
    }

    public Cliente cadastrar(ClienteDTO clienteDTO) {
        DadosPessoais dadosPessoais;
        Endereco endereco;
        StatusCliente statusCliente = StatusCliente.ATIVO;
        dadosPessoais = new DadosPessoais(clienteDTO.getCpf(), clienteDTO.getNome(), clienteDTO.getProfissao(), clienteDTO.getTelefone(), clienteDTO.getEmail());
        endereco = new Endereco(clienteDTO.getRua(), clienteDTO.getNumero(), clienteDTO.getBairro(), clienteDTO.getCidade(), clienteDTO.getEstado());
        if (clienteDTO.getComplemento() != null) {
            endereco.setComplemento(clienteDTO.getComplemento());
        }
        if (clienteDTO.getStatus().equals("SUSPENSO")) {
            statusCliente = StatusCliente.SUSPENSO;
        }
        return new Cliente(clienteDTO.getRenda(), dadosPessoais, endereco, statusCliente);
    }

    public Cliente alterar(Cliente cliente, ClienteDTO clienteDTO){
        DadosPessoais dadosPessoais = new DadosPessoais(clienteDTO.getCpf(), clienteDTO.getNome(),
                clienteDTO.getProfissao(), clienteDTO.getTelefone(), clienteDTO.getEmail());

        Endereco endereco = new Endereco(clienteDTO.getRua(), clienteDTO.getNumero(), clienteDTO.getBairro(),
                clienteDTO.getCidade(), clienteDTO.getEstado());
        if(clienteDTO.getComplemento() != null){
            endereco.setComplemento(clienteDTO.getComplemento());
        }

        cliente.setRenda(clienteDTO.getRenda());
        cliente.setDadosPessoais(dadosPessoais);
        cliente.setEndereco(endereco);
        if(clienteDTO.getStatus().equals("ATIVO")){
            cliente.setStatus(StatusCliente.ATIVO);
        }else {
            cliente.setStatus(StatusCliente.SUSPENSO);
        }

        return cliente;
    }
}
