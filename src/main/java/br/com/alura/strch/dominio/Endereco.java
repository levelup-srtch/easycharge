package br.com.alura.strch.dominio;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName
    private String rua;

    @CsvBindByName
    private String numero;

    @CsvBindByName
    private String complemento;

    @CsvBindByName
    private String bairro;

    @CsvBindByName
    private String cidade;

    @CsvBindByName
    private String estado;

    @OneToOne(mappedBy = "endereco")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(Long id, String rua, String numero, String complemento, String bairro, String cidade, String estado, Cliente cliente) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cliente = cliente;
    }
}
