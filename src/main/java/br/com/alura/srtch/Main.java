package br.com.alura.srtch;

import br.com.alura.srtch.DAO.ClienteDAO;
import br.com.alura.srtch.DAO.EnderecoDAO;
import br.com.alura.srtch.dominio.Cliente;
import br.com.alura.srtch.servico.ClientesPorEstado;
import br.com.alura.srtch.servico.RendaClienteSuspenso;
import br.com.alura.srtch.servico.LeituraDeArquivos;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes = new LeituraDeArquivos().lerArquivo(arquivo);

    System.out.println("# Limites de dívidas dos clientes");
    for (Cliente cliente : clientes) {
      BigDecimal limiteDivida = cliente.getRenda().multiply(BigDecimal.valueOf(12));
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.\n", cliente.getNome(), limiteDivida);
    }

    new RendaClienteSuspenso().somaRendaClientesSuspensos(clientes);

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }
    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
    }

    EntityManager em = JPAUtil.getEntityManager();
    ClienteDAO clienteDAO = new ClienteDAO(em);
    EnderecoDAO enderecoDAO = new EnderecoDAO(em);

    em.getTransaction().begin();

    for (Cliente cliente : clientes){
      enderecoDAO.cadastrar(cliente.getEndereco());
      clienteDAO.cadastrar(cliente);
    }
    clienteDAO.buscarTodos();

    em.getTransaction().commit();
    em.close();


  }

}