package br.com.alura.srtch.modelo;

import br.com.alura.srtch.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ClientesPorEstado extends TreeMap<String, List<Cliente>> {

  private String estado;

  public void adicionaCliente(Cliente cliente) {
    this.estado = cliente.getEndereco().getEstado();
    List<Cliente> clientes = get(this.estado);
    if (clientes == null) {
      clientes = new ArrayList<>();
    }
    clientes.add(cliente);
    put(this.estado, clientes);
  }
}
