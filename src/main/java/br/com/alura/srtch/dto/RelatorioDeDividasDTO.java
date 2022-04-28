package br.com.alura.srtch.dto;

import java.math.BigDecimal;

public class RelatorioDeDividasDTO {

    private String nome;
    private BigDecimal valorDasDividas;
    private Long numeroDeCobrancas;

    public RelatorioDeDividasDTO(String nome, BigDecimal valorDasDividas, Long numeroDeCobrancas) {
        this.nome = nome;
        this.valorDasDividas = valorDasDividas;
        this.numeroDeCobrancas = numeroDeCobrancas;
    }

    @Override
    public String toString() {
        return "RelatorioNomeCliente{" +
                "Nome do cliente: '" + nome + '\'' +
                ", Valor total das dividas: " + valorDasDividas +
                ", Número total de cobranças: " + numeroDeCobrancas +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValorDasDividas() {
        return valorDasDividas;
    }

    public Long getNumeroDeCobrancas() {
        return numeroDeCobrancas;
    }
}
