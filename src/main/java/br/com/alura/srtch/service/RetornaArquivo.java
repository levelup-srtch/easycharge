package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.RecebeClienteDoArquivo;

import java.util.List;

public interface RetornaArquivo {

    List<RecebeClienteDoArquivo> RecebeArquivo(String arquivo);

}
