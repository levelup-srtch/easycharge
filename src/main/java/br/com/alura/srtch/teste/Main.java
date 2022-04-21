package br.com.alura.srtch.teste;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.ClientesPorEstado;
import br.com.alura.srtch.service.ArquivoCSV;
import br.com.alura.srtch.service.ArquivoJSON;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.LimiteDeDividas;


import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes;

    if (arquivo.endsWith(".csv")) {
      ArquivoCSV arquivoCSV = new ArquivoCSV();
      clientes = arquivoCSV.RecebeArquivo(arquivo);

    } else if (arquivo.endsWith(".json")) {
      ArquivoJSON arquivoJSON = new ArquivoJSON();
      clientes = arquivoJSON.retornaArquivoJSON(arquivo);
    } else {
      throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
    }

    System.out.println("# Limites de dívidas dos clientes");
    LimiteDeDividas ldm = new LimiteDeDividas();
    ldm.MostrarLimiteDeDividasDosClientes(clientes);

    ClientesSuspensos rcs = new ClientesSuspensos();
    rcs.somaRendaDosClientesSuspensos(clientes);
    rcs.mostraClientesSuspensos();
    System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f\n\n", rcs.mediaRendaClientesSuspensos());

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    clientesPorEstado.adicionaTodosOsClientes(clientes);
    clientesPorEstado.mostraClientesPorEstado(clientesPorEstado);

  }
}