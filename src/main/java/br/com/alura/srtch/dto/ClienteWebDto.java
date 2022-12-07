package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public class ClienteWebDto {

    private Long id;
    private final String nome;
    private final String cpf;
    private final String telefone;
    private final String local;
    private final BigDecimal renda;
    private final StatusCliente status;

    public ClienteWebDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getDadosPessoais().getNome();
        this.cpf = cliente.getDadosPessoais().getCpf();
        this.telefone = cliente.getDadosPessoais().getTelefone();
        this.local = cliente.getEndereco().getCidade()+ "/" +cliente.getEndereco().getEstado();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getLocal() {
        return local;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public static Page<ClienteWebDto> converter(Page<Cliente> clientes){
        return clientes.map(ClienteWebDto::new);
    }

    public static List<ClienteWebDto> converterLista(List<Cliente> clientes){
        return clientes.stream().map(ClienteWebDto::new).toList();
    }

}
