package br.com.alura.srtch.config.validacao;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;

import java.math.BigDecimal;

public class ErroDoValorDaDivida {
    public static boolean validar(BigDecimal valor, Long idCliente, ClienteRepository clienteRepository, DividaRepository dividaRepository) {
        Cliente cliente = clienteRepository.getById(idCliente);
        BigDecimal valorTotal = dividaRepository.buscaSomaDoValorDaDivida(idCliente);
        if (valorTotal.add(valor).doubleValue() > new BigDecimal(12).multiply(cliente.getRenda()).doubleValue()){
            return true;
        }
        return false;
    }
}
