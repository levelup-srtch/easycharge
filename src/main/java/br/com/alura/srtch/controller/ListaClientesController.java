package br.com.alura.srtch.controller;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.DadosPessoais;
import br.com.alura.srtch.modelo.Endereco;
import br.com.alura.srtch.modelo.StatusCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Controller
public class ListaClientesController {

    @GetMapping("/listaClientes")
    public String home(Model model){
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        endereco.setCidade("Brasilia");
        endereco.setEstado("DF");
        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf("05851040181");
        dadosPessoais.setNome("Gabriel");
        cliente.setRenda(new BigDecimal(2000));
        cliente.setDadosPessoais(dadosPessoais);
        cliente.setEndereco(endereco);
        cliente.setStatus(StatusCliente.ATIVO);

        List<Cliente> clientes = Arrays.asList(cliente);
        model.addAttribute("clientes", clientes);

        return "listaClientes";
    }
}
