package br.com.alura.srtch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("listaClientes")
public class NovoClienteController {

    @GetMapping("/novoCliente")
    public String novoCliente(){
        return "cliente/novoCliente";
    }

}
