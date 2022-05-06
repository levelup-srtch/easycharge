package br.com.alura.srtch.test;

import br.com.alura.srtch.controller.ClienteController;
import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.service.TipoDoArquivo;

import java.util.List;

public class TestaCadastrarClientes {
    public static void main(String[] args) {
        if (args.length <= 0) {
            throw new IllegalArgumentException("Forneça um nome de arquivo.");
        }

        String arquivo = args[0];

        List<ClienteDTO> recebeClienteDoArquivos = new TipoDoArquivo().validaTipoDoArquivo(arquivo);

        ClienteController clienteController = new ClienteController();
        clienteController.cadastrarDTO(recebeClienteDoArquivos);

    }
}
