package br.com.alura.srtch.dominio;

import br.com.alura.srtch.dominio.enuns.FormaDeCobraca;
import br.com.alura.srtch.dominio.enuns.TipoDeAcordo;
import br.com.alura.srtch.dominio.enuns.TipoDeAgente;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cobrancas")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaCobranca;

    @Enumerated(EnumType.STRING)
    private FormaDeCobraca formaDeCobraca;

    private String agente;

    @Enumerated(EnumType.STRING)
    private TipoDeAgente tipoDeAgente;

    private String comentarioAgente;

    private String descricaoDoAcordo;

    private TipoDeAcordo tipoDeAcordo;




}
