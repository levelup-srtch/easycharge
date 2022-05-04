package br.com.alura.srtch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.EntityManager;


import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.modelo.ClientesPorEstado;
import br.com.alura.srtch.easycharge.modelo.StatusCliente;
import br.com.alura.srtch.service.ArquivoJSON;
import br.com.alura.srtch.util.JPAUtil;

// classe com função de ler csv, json, calcular dívidas e imprimir resultados, deve ser segregada. 
public class Main {

  public static void main(String[] args) {
	  
	 // cadastrarCliente();
	  
	  EntityManager em = JPAUtil.getEntityManager();
	  ClienteDao clienteDao = new ClienteDao(em);
	  
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    List<Cliente> clientes;
    
   if (arquivo.matches(".*json")) {
        clientes = new ArquivoJSON().Ler(arquivo);
      } else {
        throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
      }

    System.out.println("# Limites de dívidas dos clientes");
    for (Cliente cliente : clientes) {
      BigDecimal limiteDivida = cliente.getRenda().multiply(BigDecimal.valueOf(12));
      System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.\n", cliente.getNome(), limiteDivida);
    }

    BigDecimal somaRendaClientesSuspensos = BigDecimal.ZERO;
    int numeroClientesSuspensos = 0;
    for (Cliente cliente : clientes) {
      if (StatusCliente.SUSPENSO.equals(cliente.getStatus())) {
        numeroClientesSuspensos++;
        somaRendaClientesSuspensos = somaRendaClientesSuspensos.add(cliente.getRenda());
      }
    }
    BigDecimal mediaRendaClientesSuspensos = somaRendaClientesSuspensos.divide(BigDecimal.valueOf(numeroClientesSuspensos), 2, RoundingMode.HALF_UP);

    System.out.printf("\nHá %s clientes suspensos.\n", numeroClientesSuspensos);
    System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f\n\n", mediaRendaClientesSuspensos);


    ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
    for (Cliente cliente : clientes) {
      clientesPorEstado.adicionaCliente(cliente);
    }
    System.out.println("# Clientes por estado");
    for (String estado : clientesPorEstado.keySet()) {
      List<Cliente> clientesDoEstado = clientesPorEstado.get(estado);
      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
    }
     
     
    for (Cliente cliente : clientes) {
    	ClienteDao clienteDao0 = new ClienteDao(em);
    	em.getTransaction().begin(); 
		clienteDao0.cadastrar(cliente);
		em.getTransaction().commit(); 
		//em.close();
    }
    
    //Cliente c = clienteDao.buscarPorId(2l);
   // System.out.println(c.getNome()); 
    
    clientes  = clienteDao.buscarTodos();
    clientes.forEach(c -> System.out.println(c));
    clientes.forEach(c -> System.out.println(c.getNome()));

    clientes = clienteDao.buscarPorNome("Emily Vera Marcela Silveira");
    System.out.println("----------------BUSCA POR NOME Emily-");
	clientes.forEach(c -> System.out.println(c.getNome()));
    
    clientes = clienteDao.buscarPorAtivo(StatusCliente.ATIVO);
    System.out.println("----------------ATIVOS---------------");
    clientes.forEach(c -> System.out.println(c.getNome()));
    clientes = clienteDao.buscarPorAtivo(StatusCliente.SUSPENSO);
    System.out.println("--------------SUSPENSOS--------------");
    clientes.forEach(c -> System.out.println(c.getNome()));
	
  }
  
  /*
  private static void cadastrarCliente() {
	   
	  // outro metodo seria criar o endereço no banco primeiro.
	 
		Cliente cliente = new Cliente(
		 "Yasmin Ester Lara Nogueira",
		 "040.141.961-43",
		 "(61) 98439-7036",
		 "yasminesternogueira@munhozengenharia.com.br",
		 "Engenheira",
		 new BigDecimal("9168"),
		 StatusCliente.ATIVO,
		 new Endereco("Quadra QS 20 Conjunto 2","669","ap 175","Riacho Fundo II","Brasília","DF"));
				 
		
		EntityManager em = JPAUtil.getEntityManager();
		ClienteDao clienteDao = new ClienteDao(em);
		em.getTransaction().begin(); 
		clienteDao.cadastrar(cliente);
		em.getTransaction().commit(); 
		//em.close();
	*/	
		
}
