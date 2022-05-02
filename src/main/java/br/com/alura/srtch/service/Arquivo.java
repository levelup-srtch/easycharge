package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;

import java.util.List;

public interface Arquivo {

    List<ClienteDTO> arquivo(String arquivo);

}
