package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;

import java.util.List;

public interface RetornaArquivo {

    List<Cliente> RecebeArquivo(String arquivo);

}
