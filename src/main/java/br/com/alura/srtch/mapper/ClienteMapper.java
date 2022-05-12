package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDto;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteMapper {

    public List<Cliente> cadastrar(List<ClienteForm> forms) {
        List<Cliente> clientes = new ArrayList<>();
        DadosPessoais dadosPessoais;
        Endereco endereco;
        StatusCliente statusCliente = StatusCliente.ATIVO;
        for (ClienteForm cda : forms) {
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

    public Cliente cadastrar(ClienteForm form) {
        DadosPessoais dadosPessoais;
        Endereco endereco;
        StatusCliente statusCliente = StatusCliente.ATIVO;
        dadosPessoais = new DadosPessoais(form.getCpf(), form.getNome(), form.getProfissao(), form.getTelefone(), form.getEmail());
        endereco = new Endereco(form.getRua(), form.getNumero(), form.getBairro(), form.getCidade(), form.getEstado());
        if (form.getComplemento() != null) {
            endereco.setComplemento(form.getComplemento());
        }
        if (form.getStatus().equals("SUSPENSO")) {
            statusCliente = StatusCliente.SUSPENSO;
        }
        return new Cliente(form.getRenda(), dadosPessoais, endereco, statusCliente);
    }

    public void alterar(Cliente cliente, ClienteDto dto){
        DadosPessoais dadosPessoais = new DadosPessoais(dto.getCpf(), dto.getNome(),
                dto.getProfissao(), dto.getTelefone(), dto.getEmail());

        Endereco endereco = new Endereco(dto.getRua(), dto.getNumero(), dto.getBairro(),
                dto.getCidade(), dto.getEstado());
        if(dto.getComplemento() != null){
            endereco.setComplemento(dto.getComplemento());
        }

        cliente.setRenda(dto.getRenda());
        cliente.setDadosPessoais(dadosPessoais);
        cliente.setEndereco(endereco);
        if(dto.getStatus().equals("ATIVO")){
            cliente.setStatus(StatusCliente.ATIVO);
        }else {
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
    }
}
