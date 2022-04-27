package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.StatusCliente;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class ClientesSuspensos {

    private BigDecimal somaDaRenda = new BigDecimal(BigInteger.ZERO);
    private int numeroDeClientes;

    public void somarRenda(List<Cliente> clientes){
        for (Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getStatus())) {
                this.numeroDeClientes++;
                this.somaDaRenda = this.somaDaRenda.add(cliente.getRenda());
            }
        }
    }

    public BigDecimal mediaDaRenda(){
        return somaDaRenda.divide(BigDecimal.valueOf(this.numeroDeClientes), 2, RoundingMode.HALF_UP);
    }

    public int getNumeroDeClientes() {
        return numeroDeClientes;
    }
}
