package br.com.alura.srtch.dto;

public class RelatorioDeCobrancas {

    private final String cpf;
    private final Long quantidadeDeCobrancas;

    public RelatorioDeCobrancas(String cpf, Long quantidadeDeCobrancas) {
        this.cpf = cpf;
        this.quantidadeDeCobrancas = quantidadeDeCobrancas;
    }

    @Override
    public String toString() {
        return "RelatorioDeCobrancas[" + "cpfCliente='" + cpf +
                ", quantidadeDeCobranças=" + quantidadeDeCobrancas +
                "]";
    }

    public String getCpf() {
        return cpf;
    }

    public Long getQuantidadeDeCobrancas() {
        return quantidadeDeCobrancas;
    }
}
