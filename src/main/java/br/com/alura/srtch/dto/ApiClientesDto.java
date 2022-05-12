package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.StatusCliente;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ApiClientesDto{

    private final String nome;
    private final String CPF;
    private final String telefone;
    private final String local;
    private final BigDecimal renda;
    private final StatusCliente status;

    public ApiClientesDto(Cliente cliente) {
        this.nome = cliente.getDadosPessoais().getNome();
        this.CPF = cliente.getDadosPessoais().getCpf();
        this.telefone = cliente.getDadosPessoais().getTelefone();
        this.local = cliente.getEndereco().getCidade()+ "/" +cliente.getEndereco().getEstado();
        this.renda = cliente.getRenda();
        this.status = cliente.getStatus();
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return CPF;
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

    public static List<ApiClientesDto> converter(List<Cliente> clientes){
        return clientes.stream().map(ApiClientesDto::new).collect(Collectors.toList());
    }
}
