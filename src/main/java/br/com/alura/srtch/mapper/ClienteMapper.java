package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.AtualizacaoClienteForm;
import br.com.alura.srtch.form.AtualizacaoWebClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;

public class ClienteMapper {

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

    public void alterar(Cliente cliente, AtualizacaoWebClienteForm form) {
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

        if (form.getComplemento() != null) {
            cliente.setComplemento(form.getComplemento());
        }
        if (form.getStatus().equals("ATIVO")) {
            cliente.setStatus(StatusCliente.ATIVO);
        } else {
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

        if (form.getComplemento() != null) {
            cliente.setComplemento(form.getComplemento());
        }
        if (form.getStatus().equals("ATIVO")) {
            cliente.setStatus(StatusCliente.ATIVO);
        } else {
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
        return cliente;
    }
}
