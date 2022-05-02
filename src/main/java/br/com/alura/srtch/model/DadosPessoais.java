package br.com.alura.srtch.model;

import javax.persistence.*;

@Embeddable
public class DadosPessoais {

    @Column(nullable=false, length=14)
    private String cpf;

    @Column(nullable=false, length=100)
    private String nome;

    @Column(nullable=false, length=50)
    private String profissao;

    @Column(nullable=false, length=15)
    private String telefone;

    @Column(nullable=false, length=100)
    private String email;


    public DadosPessoais() {
    }

    public DadosPessoais(String cpf, String nome, String profissao, String telefone, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.profissao = profissao;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DadosPessoais{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", profissao='" + profissao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
