package br.com.alura.srtch.modelo;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cadastro")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(required = true)
    private String telefone;

    @CsvBindByName(required = true)
    private String email;

    @CsvBindByName(required = true)
    private StatusCliente status;

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

}
