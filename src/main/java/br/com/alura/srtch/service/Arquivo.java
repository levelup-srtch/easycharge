package br.com.alura.srtch.service;

import br.com.alura.srtch.vo.ClienteDoArquivo;

import java.util.List;

public interface Arquivo {

    List<ClienteDoArquivo> arquivo(String arquivo);

}
