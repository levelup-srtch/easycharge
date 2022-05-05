package br.com.alura.srtch.easycharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;

@Controller
public class ListaClientesController {
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@GetMapping("/listaclientes")
	public String home(Model model) {
		List<Cliente> clientes = clienterepository.findAll();
		model.addAttribute("clientes", clientes);
		return "listaclientes"; 
	}
}
