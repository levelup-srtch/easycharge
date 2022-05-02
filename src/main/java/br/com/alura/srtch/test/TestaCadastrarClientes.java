//package br.com.alura.srtch.test;
//
//import br.com.alura.srtch.dto.ClienteDTO;
//import br.com.alura.srtch.dto.ClienteMapper;
//import br.com.alura.srtch.model.Cliente;
//import br.com.alura.srtch.service.TipoDoArquivo;
//
//import java.util.List;
//
//public class TestaCadastrarClientes {
//    public static void main(String[] args) {
//        if (args.length <= 0) {
//            throw new IllegalArgumentException("Forneça um nome de arquivo.");
//        }
//
//        String arquivo = args[0];
//
//        List<ClienteDTO> recebeClienteDoArquivos = new TipoDoArquivo().validaTipoDoArquivo(arquivo);
//
//        List<Cliente> clientes = new ClienteMapper().transformarEmCliente(recebeClienteDoArquivos);
//    }
//}
