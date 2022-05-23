package br.com.alura.srtch.mapper;

import br.com.alura.srtch.dto.ClienteDto;
import br.com.alura.srtch.form.AtualizacaoClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.repository.ClienteRepository;

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
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setRua(dto.getRua());
        cliente.setNumero(dto.getNumero());
        cliente.setBairro(dto.getBairro());
        cliente.setCidade(dto.getCidade());
        cliente.setEstado(dto.getEstado());
        cliente.setProfissao(dto.getProfissao());
        cliente.setRenda(dto.getRenda());

        if(dto.getComplemento() != null){
            cliente.setComplemento(dto.getComplemento());
        }
        if(dto.getStatus().name().equals("ATIVO")){
            cliente.setStatus(StatusCliente.ATIVO);
        }else {
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
    }

    public Cliente atualizar(Cliente cliente, AtualizacaoClienteForm form) {

        cliente.setNome(form.getNome());
        cliente.setTelefone(form.getTelefone());
        cliente.setEmail(form.getEmail());
        cliente.setRua(form.getRua());
        cliente.setNumero(form.getNumero());
        cliente.setBairro(form.getBairro());
        cliente.setCidade(form.getCidade());
        cliente.setEstado(form.getEstado());
        cliente.setProfissao(form.getProfissao());
        cliente.setRenda(form.getRenda());

        if(form.getComplemento() != null){
            cliente.setComplemento(form.getComplemento());
        }
        if(form.getStatus().equals("ATIVO")){
            cliente.setStatus(StatusCliente.ATIVO);
        }else {
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
        return cliente;
    }
}
