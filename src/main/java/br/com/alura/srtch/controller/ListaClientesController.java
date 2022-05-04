package br.com.alura.srtch.controller;

import br.com.alura.srtch.model.StatusCliente;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ListaClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";

    @GetMapping
    public String listarCliente(Model model){

        List<Cliente> clientes = clienteRepository.findAll();

        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return REDIRECT_CLIENTES;
    }

    @GetMapping("/alterarStatus/{id}")
    public String alterarStatus(@PathVariable Long id, Model model) {
        Cliente cliente = clienteRepository.getById(id);
        if(cliente.getStatus().equals(StatusCliente.SUSPENSO)){
            cliente.setStatus(StatusCliente.ATIVO);
        }else{
            cliente.setStatus(StatusCliente.SUSPENSO);
        }
        clienteRepository.save(cliente);

        model.addAttribute("cliente", cliente);
        return REDIRECT_CLIENTES;
    }

    @GetMapping("/remover/{id}")
    public String removerCliente(@PathVariable Long id){
        Cliente cliente = clienteRepository.getById(id);
        clienteRepository.delete(cliente);

        return REDIRECT_CLIENTES;
    }
}
