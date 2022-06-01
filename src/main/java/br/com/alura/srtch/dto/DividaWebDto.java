package br.com.alura.srtch.dto;

import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.model.StatusDivida;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DividaWebDto {

    private Long id;

    private BigDecimal valor;

    private LocalDate dataDeAbertura;

    private StatusDivida status;

    private Long idCliente;

    public DividaWebDto(Divida divida){
        this.id = divida.getId();
        this.valor = divida.getValor();
        this.dataDeAbertura = divida.getDataDeAbertura();
        this.status = divida.getStatus();
        this.idCliente = divida.getCliente().getId();
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

    public StatusDivida getStatus() {
        return status;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public static List<DividaWebDto> converter(List<Divida> dividas){
        return dividas.stream().map(DividaWebDto::new).collect(Collectors.toList());
    }
}
