package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.StatusCliente;

import java.math.BigDecimal;

public class ClienteDTO {

    private String nome;

    private String cpf;

    private String telefone;

    private String email;

    private String rua;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    private String profissao;

    private BigDecimal renda;

    private String status;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getProfissao() {
        return profissao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public String getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
