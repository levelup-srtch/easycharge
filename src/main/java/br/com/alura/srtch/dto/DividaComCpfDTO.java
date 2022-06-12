package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.StatusDivida;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DividaComCpfDTO {

    private Long id;

    private BigDecimal valor;

    private LocalDate dataDeAbertura;

    private LocalDate dataDeQuitacao;

    private StatusDivida status;

    private String descricaoDeQuitacao;

    private String cpf;

    public DividaComCpfDTO(Divida divida) {
        this.id = divida.getId();
        this.valor = divida.getValor();
        this.dataDeAbertura = divida.getDataDeAbertura();
        this.dataDeQuitacao = divida.getDataDeQuitacao();
        this.status = divida.getStatus();
        this.descricaoDeQuitacao = divida.getDescricaoDeQuitacao();
        this.cpf = divida.getCliente().getCpf();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }

    public LocalDate getDataDeQuitacao() {
        return dataDeQuitacao;
    }

    public StatusDivida getStatus() {
        return status;
    }

    public String getDescricaoDeQuitacao() {
        return descricaoDeQuitacao;
    }

    public String getCpf() {
        return cpf;
    }

    public static Page<DividaComCpfDTO> converter(Page<Divida> dividas) {
        return dividas.map(DividaComCpfDTO::new);
    }

}
