package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;

import java.util.List;

public class TipoDoArquivo {

    List<ClienteDTO> clientesDoArquivo;

    public List<ClienteDTO> validaTipoDoArquivo(String arquivo){
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
