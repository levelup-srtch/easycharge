package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.StatusCliente;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class ClientesSuspensos {

    private BigDecimal somaRendaClientesSuspensos = new BigDecimal(BigInteger.ZERO);
    private int numeroClientesSuspensos;

    public void somaRendaDosClientesSuspensos(List<Cliente> clientes){
        for (Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getCadastro().getStatus())) {
                this.numeroClientesSuspensos++;
                this.somaRendaClientesSuspensos = this.somaRendaClientesSuspensos.add(cliente.getRenda());
            }
        }
    }

    public BigDecimal mediaRendaClientesSuspensos(){
        return somaRendaClientesSuspensos.divide(BigDecimal.valueOf(this.numeroClientesSuspensos), 2, RoundingMode.HALF_UP);
    }

    public int getNumeroClientesSuspensos() {
        return numeroClientesSuspensos;
    }
}
