package br.com.alura.srtch.DTO;

public class RelatorioDeCobranca {

    private Long id;
    private Long numeroDeCobranca;

    public RelatorioDeCobranca(Long id, Long numeroDeCobranca) {
        this.id = id;
        this.numeroDeCobranca = numeroDeCobranca;
    }

    public Long getId() {
        return id;
    }

    public Long getNumeroDeCobranca() {
        return numeroDeCobranca;
    }

    @Override
    public String toString() {
        return "RelatorioDeCobrancas= " + "idCliente=" + id +
                ", numeroDeCobranças=" + numeroDeCobranca;
    }
}
