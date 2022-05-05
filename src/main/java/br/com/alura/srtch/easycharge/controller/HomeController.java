package br.com.alura.srtch.easycharge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class HomeController {

	/*
	@Autowired
	private ClienteRepository clienterepository;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Cliente> clientes = clienterepository.findAll();
		model.addAttribute("clientes", clientes);
		return "home"; 
	}
		*/
	// @GetMapping("/home")
	
	@RequestMapping(value={"", "/", "welcome","home"})
		//@ResponseBody
	public String home() {
		return "home";
	
	}
	
	@GetMapping("/hello2")
	public String hello () {
		return "hello";
	
	}
	
	

}
