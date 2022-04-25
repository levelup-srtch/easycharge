package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.CadastroDAO;
import br.com.alura.srtch.dao.ClienteDAO;
import br.com.alura.srtch.dao.EnderecoDAO;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.ClientesPorEstado;
import br.com.alura.srtch.modelo.RecebeClienteDoArquivo;
import br.com.alura.srtch.modelo.StatusCliente;
import br.com.alura.srtch.service.ClientesSuspensos;
import br.com.alura.srtch.service.ParseCliente;
import br.com.alura.srtch.service.ValidacaoTipoDoArquivo;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<RecebeClienteDoArquivo> recebeClienteDoArquivos = new ValidacaoTipoDoArquivo().validaTipoDoArquivo(arquivo);

    List<Cliente> clientes = new ParseCliente().transformarEmCliente(recebeClienteDoArquivos);

    System.out.println("# Limites de dívidas dos clientes");
    for(Cliente cliente : clientes){
      cliente.setLimiteDeDivida();
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.%n", cliente.getRenda(), cliente.getLimiteDivida());
    }

    ClientesSuspensos rcs = new ClientesSuspensos();
    rcs.somaRendaDosClientesSuspensos(clientes);

    System.out.printf("%nHá %s clientes suspensos.%n", rcs.getNumeroClientesSuspensos());

    System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f%n%n", rcs.mediaRendaClientesSuspensos());

    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }

    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).%n", estado, clientesDoEstado.size());
    }

    EntityManager em = JPAUtil.getEntityManager();
    ClienteDAO clienteDAO = new ClienteDAO(em);
    CadastroDAO cadastroDAO = new CadastroDAO(em);
    EnderecoDAO enderecoDAO = new EnderecoDAO(em);

    em.getTransaction().begin();

    for (Cliente cliente : clientes){
      cadastroDAO.cadastrar(cliente.getCadastro());
      enderecoDAO.cadastrar(cliente.getEndereco());
      clienteDAO.cadastrar(cliente);
    }

    clienteDAO.buscarPorNome("Carlos Renato Benício Ferreira");

    clienteDAO.buscarTodosPorStatus(StatusCliente.ATIVO);

    em.getTransaction().commit();
    em.close();

  }
}