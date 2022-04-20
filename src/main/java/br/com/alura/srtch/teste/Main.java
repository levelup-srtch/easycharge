package br.com.alura.srtch.teste;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.ClientesPorEstado;
import br.com.alura.srtch.service.LimiteDeDividas;
import br.com.alura.srtch.service.RendaClientesSuspensos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes;

    if (arquivo.endsWith(".csv")) {
      try {
        Reader reader = new FileReader(arquivo);
        CsvToBean<Cliente> csvToBean = new CsvToBeanBuilder<Cliente>(reader)
            .withType(Cliente.class)
            .build();
        clientes = csvToBean.parse();
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
    } else if (arquivo.endsWith(".json")) {
      try {
        Reader reader = new FileReader(arquivo);
        ObjectMapper mapper = new ObjectMapper();

        clientes = mapper.readValue(reader, new TypeReference<>() {
        });
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
    } else {
      throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
    }

    LimiteDeDividas ldm = new LimiteDeDividas();
    ldm.MostrarLimiteDeDividasDosClientes();

    RendaClientesSuspensos rcs = new RendaClientesSuspensos();
    rcs.somaRendaDosClientesSuspensos();
    rcs.mostraClientesSuspensos();
    System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f\n\n", rcs.mediaRendaClientesSuspensos());

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }
    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
    }


  }

}