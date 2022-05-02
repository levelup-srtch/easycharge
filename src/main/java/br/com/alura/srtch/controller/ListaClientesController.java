package br.com.alura.srtch.controller;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.DadosPessoais;
import br.com.alura.srtch.model.Endereco;
import br.com.alura.srtch.model.StatusCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ListaClientesController {

    @GetMapping("/listaClientes")
    public String home(Model model){

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        endereco.setCidade("Santa Maria");
        endereco.setEstado("DF");
        DadosPessoais dadosPessoais = new DadosPessoais();
        dadosPessoais.setCpf("00033311144");
        dadosPessoais.setNome("Gabriel Almeida");
        cliente.setRenda(new BigDecimal(2800));
        cliente.setDadosPessoais(dadosPessoais);
        cliente.setEndereco(endereco);

        Cliente cliente2 = new Cliente();
        Endereco endereco2 = new Endereco();
        endereco2.setCidade("Gama");
        endereco2.setEstado("DF");
        DadosPessoais dadosPessoais2 = new DadosPessoais();
        dadosPessoais2.setCpf("00099988822");
        dadosPessoais2.setNome("Vitória Martins");
        cliente2.setRenda(new BigDecimal(5700));
        cliente2.setDadosPessoais(dadosPessoais2);
        cliente2.setEndereco(endereco2);

        List<Cliente> clientes = Arrays.asList(cliente, cliente2);
        model.addAttribute("clientes", clientes);

        return "listaClientes";
    }
}
