package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Cliente;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
public class EnderecoDTO implements Serializable {

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

    public EnderecoDTO() {
    }

    public EnderecoDTO(Long id, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

}
