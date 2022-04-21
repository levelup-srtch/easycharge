package br.com.alura.srtch.modelo;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "cadastro")
public class Cadastro{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(required = true)
    @Column(length = 14)
    private String telefone;

    @Column(length = 100)
    @CsvBindByName(required = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @CsvBindByName(required = true)
    private StatusCliente status;

    public Cadastro() {
    }

    public Cadastro(String telefone, String email, StatusCliente status) {
        this.telefone = telefone;
        this.email = email;
        this.status = status;
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

    public StatusCliente getStatus() {
        return status;
    }

    public void setStatus(StatusCliente status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cadastro{" +
                "telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
