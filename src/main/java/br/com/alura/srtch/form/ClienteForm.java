package br.com.alura.srtch.form;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ClienteForm {

    @NotBlank(message = "O campo nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O campo CPF não pode estar em branco")
//    @CPF
    private String cpf;

    @NotBlank(message = "O campo telefone não pode estar em branco")
    private String telefone;

    @NotBlank(message = "O campo e-mail não pode estar em branco")
    @Email
    private String email;

    @NotBlank(message = "O campo rua não pode estar em branco")
    private String rua;

    @NotBlank(message = "O campo número não pode estar em branco")
    private String numero;

    private String complemento;

    @NotBlank(message = "O campo bairro não pode estar em branco")
    private String bairro;

    @NotBlank(message = "O campo cidade não pode estar em branco")
    private String cidade;

    @NotBlank(message = "O campo estado não pode estar em branco")
    private String estado;

    @NotBlank(message = "O campo profissão não pode estar em branco")
    private String profissao;

    @NotNull(message = "O campo renda não pode ser nulo")
    @Positive(message = "O valor da renda precisa ser maior que 0")
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
