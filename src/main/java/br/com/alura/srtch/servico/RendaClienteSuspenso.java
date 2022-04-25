package br.com.alura.srtch.servico;

import br.com.alura.srtch.dominio.Cliente;
import br.com.alura.srtch.dominio.enuns.StatusCliente;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class RendaClienteSuspenso {

    public void somaRendaClientesSuspensos(List<Cliente>clientes) {
        BigDecimal somaRendaClientesSuspensos = BigDecimal.ZERO;
        int numeroClientesSuspensos = 0;

        for (
                Cliente cliente : clientes) {
            if (StatusCliente.SUSPENSO.equals(cliente.getStatus())) {
                numeroClientesSuspensos++;
                somaRendaClientesSuspensos = somaRendaClientesSuspensos.add(cliente.getRenda());
            }
        }
        BigDecimal mediaRendaClientesSuspensos = somaRendaClientesSuspensos.divide(BigDecimal.valueOf(numeroClientesSuspensos), 2, RoundingMode.HALF_UP);

        System.out.printf("\nHá %s clientes suspensos.\n", numeroClientesSuspensos);
        System.out.printf("A média de renda dos clientes suspensos é de R$ %.2f\n\n", mediaRendaClientesSuspensos);
    }
}
