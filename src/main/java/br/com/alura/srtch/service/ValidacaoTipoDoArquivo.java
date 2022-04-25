package br.com.alura.srtch.service;

import br.com.alura.srtch.vo.RecebeClienteDoArquivo;

import java.util.List;

public class ValidacaoTipoDoArquivo {

    List<RecebeClienteDoArquivo> recebeClienteDoArquivos;

    public List<RecebeClienteDoArquivo> validaTipoDoArquivo(String arquivo){
        if (arquivo.endsWith(".csv")) {
            this.recebeClienteDoArquivos = new ArquivoCSV().RecebeArquivo(arquivo);
        } else if (arquivo.endsWith(".json")) {
            this.recebeClienteDoArquivos = new ArquivoJSON().RecebeArquivo(arquivo);
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
        return recebeClienteDoArquivos;
    }



}
