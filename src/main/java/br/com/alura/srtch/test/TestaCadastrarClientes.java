package br.com.alura.srtch.test;

import br.com.alura.srtch.controller.ClientesController;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.service.TipoDoArquivo;

import java.util.List;

public class TestaCadastrarClientes {
    public static void main(String[] args) {
        if (args.length <= 0) {
            throw new IllegalArgumentException("Forneça um nome de arquivo.");
        }

        String arquivo = args[0];

        List<ClienteForm> recebeClienteDoArquivos = new TipoDoArquivo().validaTipoDoArquivo(arquivo);

        ClientesController clienteController = new ClientesController();
        clienteController.cadastrarDTO(recebeClienteDoArquivos);

    }
}
