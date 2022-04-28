package br.com.alura.srtch.teste;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.service.ClientesPorEstado;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.TipoDoArquivo;
import br.com.alura.srtch.dto.ClienteDoArquivo;
import br.com.alura.srtch.dto.ClienteMapper;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<ClienteDoArquivo> recebeClienteDoArquivos = new TipoDoArquivo().validaTipoDoArquivo(arquivo);

    List<Cliente> clientes = new ClienteMapper().transformarEmCliente(recebeClienteDoArquivos);

    System.out.println("# Limites de dívidas dos clientes");
    for(Cliente cliente : clientes){
      cliente.setLimiteDeDivida();
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.%n", cliente.getRenda(), cliente.getLimiteDivida());
    }

    ClientesSuspensos rcs = new ClientesSuspensos();
    rcs.somarRenda(clientes);

    System.out.printf("%nHá %s clientes suspensos.%n", rcs.getNumeroDeClientes());

    System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f%n%n", rcs.mediaDaRenda());

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }

    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).%n", estado, clientesDoEstado.size());
    }

  }
}