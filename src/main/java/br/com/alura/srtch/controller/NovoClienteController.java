package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.CadastrarCliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")
public class NovoClienteController {

    @GetMapping("novoCliente")
    public String novoCliente(){
        return "cliente/novoCliente";
    }

    @GetMapping("cadastrar")
    public String cadastrar(CadastrarCliente cadastrar){
        return "/listaCliente";
    }

}
