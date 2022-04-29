package br.com.alura.srtch.dto;

public class RelatorioDeCobrancasDTO {

    private final String cpf;
    private final Long quantidadeDeCobrancas;

    public RelatorioDeCobrancasDTO(String cpf, Long quantidadeDeCobrancas) {
        this.cpf = cpf;
        this.quantidadeDeCobrancas = quantidadeDeCobrancas;
    }

    @Override
    public String toString() {
        return "Relatorio De Cobrancas [" + "CPF do Cliente: " + cpf +
                ", Quantidade de cobranças: " + quantidadeDeCobrancas +
                "]\n";
    }

    public String getCpf() {
        return cpf;
    }

    public Long getQuantidadeDeCobrancas() {
        return quantidadeDeCobrancas;
    }
}
