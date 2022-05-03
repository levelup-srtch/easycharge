package br.com.alura.srtch.controller;

import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ListaClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/listaClientes")
    public String home(Model model){

        List<Cliente> clientes = clienteRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "listaClientes";
    }
}
