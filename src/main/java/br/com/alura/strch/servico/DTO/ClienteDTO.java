package br.com.alura.strch.servico.DTO;




import br.com.alura.strch.dominio.enuns.StatusCliente;
import com.opencsv.bean.CsvBindByName;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "clientes")
public class ClienteDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @CsvBindByName
    private String nome;

    @CPF(message = "CPF tem q ser valido!!")
    @NotBlank
    @Size(min= 11, max= 11)
    @CsvBindByName
    private String cpf;

    @NotBlank(message = "Campo obrigatorio")
    @Size(min = 11, max= 11)
    @CsvBindByName
    private String telefone;

    @NotBlank(message = "Campo obrigatorio")
    @CsvBindByName
    @Email(message = "Tem que ser um Email valido!!")
    private String email;

    @NotBlank(message = "Campo obrigatorio")
    @CsvBindByName
    private String profissao;

    @NotBlank(message = "Campo obrigatorio")
    @CsvBindByName
    private BigDecimal renda;

    @NotBlank(message = "Campo obrigatorio")
    @CsvBindByName
    private StatusCliente status;

    private SelectDTO endereco;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    public SelectDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(SelectDTO endereco) {
        this.endereco = endereco;
    }

    public ClienteDTO(Long id, String nome, String cpf, String telefone, String email, String profissao, BigDecimal renda, StatusCliente status, SelectDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.profissao = profissao;
        this.renda = renda;
        this.status = status;
        this.endereco = endereco;
    }

    public ClienteDTO() {
    }

//    @Override
//    public String toString() {
//        return "Cliente{" +
//                "nome='" + nome + '\'' +
//                ", cpf='" + cpf + '\'' +
//                ", telefone='" + telefone + '\'' +
//                ", email='" + email + '\'' +
//                ", rua='" + endereco.getRua() + '\'' +
//                ", numero='" + endereco.getNumero() + '\'' +
//                ", complemento='" +endereco.getComplemento() + '\'' +
//                ", bairro='" + endereco.getBairro() + '\'' +
//                ", cidade='" + endereco.getCidade() + '\'' +
//                ", estado='" + endereco.getEstado() + '\'' +
//                ", profissao='" + profissao + '\'' +
//                ", renda=" + renda +
//                ", status=" + status +
//                '}';
//    }
}

