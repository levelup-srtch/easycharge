package br.com.alura.srtch.mapper;

import br.com.alura.srtch.form.AtualizacaoClienteForm;
import br.com.alura.srtch.form.AtualizacaoWebClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;

public class ClienteMapper {

    public Cliente cadastrar(ClienteForm form) {
        Cliente cliente = new Cliente();
        cliente.setCpf(form.getCpf());
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

    public void alterar(Cliente cliente, AtualizacaoWebClienteForm form){
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
