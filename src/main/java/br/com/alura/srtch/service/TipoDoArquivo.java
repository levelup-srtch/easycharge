package br.com.alura.srtch.service;

import br.com.alura.srtch.vo.ClienteDoArquivo;

import java.util.List;

public class TipoDoArquivo {

    List<ClienteDoArquivo> recebeClienteDoArquivos;

    public List<ClienteDoArquivo> validaTipoDoArquivo(String arquivo){
        if (arquivo.endsWith(".csv")) {
            this.recebeClienteDoArquivos = new ArquivoCSV().arquivo(arquivo);
        } else if (arquivo.endsWith(".json")) {
            this.recebeClienteDoArquivos = new ArquivoJSON().arquivo(arquivo);
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
        return recebeClienteDoArquivos;
    }



}
