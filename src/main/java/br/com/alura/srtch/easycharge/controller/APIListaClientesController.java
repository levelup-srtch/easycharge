package br.com.alura.srtch.easycharge.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;

@Controller
public class APIListaClientesController {
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@RequestMapping("/api/listaclientes")
	@ResponseBody
	public List<Cliente> home(Model model) { 
	//public List<List<Cliente>> home(Model model) { // para retornar um array com varias listas de clientes
		List<Cliente> clientes = clienterepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("clientes", clientes);
		// return Arrays.asList(clientes,clientes,clientes); // para retornar um array com varias listas de clientes
		  return (clientes);
	}
	
	
	
}
