package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDoArquivo;

import java.util.List;

public class TipoDoArquivo {

    List<ClienteDoArquivo> clientesDoArquivo;

    public List<ClienteDoArquivo> validaTipoDoArquivo(String arquivo){
        if (arquivo.endsWith(".csv")) {
            this.clientesDoArquivo = new ArquivoCSV().arquivo(arquivo);
        } else if (arquivo.endsWith(".json")) {
            this.clientesDoArquivo = new ArquivoJSON().arquivo(arquivo);
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
        return clientesDoArquivo;
    }



}
