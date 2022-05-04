package br.com.alura.srtch.easycharge.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// usar atributo de TreeMap
public class ClientesPorEstado extends TreeMap<String, List<Cliente>> {

  public void adicionaCliente(Cliente cliente) {
    String estado = cliente.getEndereco().getEstado();
    List<Cliente> clientes = get(estado);
    if (clientes == null) {
      clientes = new ArrayList<>();
    }
    clientes.add(cliente);
    put(estado, clientes);
  }

}