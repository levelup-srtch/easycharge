package br.com.alura.srtch.dto;

import java.math.BigDecimal;

public class RelatorioDoClienteDTO {

    private final String nome;
    private final BigDecimal valorDasDividas;
    private final Long numeroDeCobrancas;

    public RelatorioDoClienteDTO(String nome, BigDecimal valorDasDividas, Long numeroDeCobrancas) {
        this.nome = nome;
        this.valorDasDividas = valorDasDividas;
        this.numeroDeCobrancas = numeroDeCobrancas;
    }

    @Override
    public String toString() {
        return "Relatorio Do Cliente[" + "Nome do Cliente: '" + nome +
                "', Valor das dividas: " + valorDasDividas +
                ", Número de Cobranças: " + numeroDeCobrancas +
                "]\n";
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
