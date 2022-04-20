package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;

import java.math.BigDecimal;
import java.util.List;

public class LimiteDeDividas {

    private BigDecimal limiteDivida;

    public void MostrarLimiteDeDividasDosClientes(List<Cliente> clientes){
        for(Cliente cliente : clientes){
            limiteDivida = cliente.getRenda().multiply(BigDecimal.valueOf(12));
            System.out.printf("- o limite máximo de dívida para %s é de R$ %.2f.\n", cliente.getNome(), limiteDivida);
        }
    }
}
