package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.form.ClienteForm;

import java.util.List;

public class TipoDoArquivo {

    List<ClienteForm> clientesDoArquivo;

    public List<ClienteForm> validaTipoDoArquivo(String arquivo){
        if (arquivo.endsWith(".json")) {
            this.clientesDoArquivo = new ArquivoJSON().arquivo(arquivo);
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
        return clientesDoArquivo;
    }

}
