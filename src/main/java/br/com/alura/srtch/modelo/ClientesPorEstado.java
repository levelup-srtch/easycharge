package br.com.alura.srtch.modelo;

import br.com.alura.srtch.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ClientesPorEstado extends TreeMap<String, List<Cliente>> {

  String estado;

  public void adicionaCliente(Cliente cliente) {
    this.estado = cliente.getEndereco().getEstado();
    List<Cliente> clientes = get(this.estado);
    if (clientes == null) {
      clientes = new ArrayList<>();
    }
    clientes.add(cliente);
    put(this.estado, clientes);
  }

  public void adicionaTodosOsClientes(List<Cliente> clientes){
    for (Cliente cliente : clientes) {
      adicionaCliente(cliente);
    }
  }

//  public void mostraClientesPorEstado(){
//    System.out.println("# Clientes por estado");
//
//    for (String estado : clientes.keySet()) {
//      List<Cliente> clientesDoEstado = clientes.get(this.estado);
//      System.out.printf("- o estado %s tem %d cliente(s) cadastrado(s).\n", estado, clientesDoEstado.size());
//    }
//  }
}
