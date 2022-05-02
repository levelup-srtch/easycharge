package br.com.alura.strch.servico.DTO;

import java.io.Serializable;

public class ListaClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private SelectDTO cargo;
    private boolean status;

    public ListaClienteDTO(Long id, String nome, SelectDTO cargo, boolean status) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.status = status;
    }

    public ListaClienteDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public SelectDTO getCargo() {
        return cargo;
    }

    public void setCargo(SelectDTO cargo) {
        this.cargo = cargo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
