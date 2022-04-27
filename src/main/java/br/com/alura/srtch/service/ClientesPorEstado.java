package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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