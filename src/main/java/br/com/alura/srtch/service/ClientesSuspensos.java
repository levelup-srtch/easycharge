package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.StatusCliente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ClientesSuspensos {

    private BigDecimal RendaClientesSuspensos;
    private int numeroClientesSuspensos;

    public BigDecimal somaRendaDosClientesSuspensos(List<Cliente> clientes){

        for (Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getCadastro().getStatus())) {
                this.numeroClientesSuspensos++;
                this.RendaClientesSuspensos = this.RendaClientesSuspensos.add(cliente.getRenda());
            }
        }
        return this.RendaClientesSuspensos;
    }

    public BigDecimal mediaRendaClientesSuspensos(){
        return this.RendaClientesSuspensos.divide(BigDecimal.valueOf(this.numeroClientesSuspensos), 2, RoundingMode.HALF_UP);
    }

    public void mostraClientesSuspensos(){
        System.out.printf("\nHá %s clientes suspensos.\n", this.numeroClientesSuspensos);
    }

    public BigDecimal getRendaClientesSuspensos() {
        return RendaClientesSuspensos;
    }

    public int getNumeroClientesSuspensos() {
        return numeroClientesSuspensos;
    }
}
