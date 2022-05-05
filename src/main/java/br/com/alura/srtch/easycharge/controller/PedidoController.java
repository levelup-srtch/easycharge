package br.com.alura.srtch.easycharge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
//@RequestMapping("pedido")
public class PedidoController {

	@GetMapping("/formulario")
	public String formulario () {
		return "formulario";
	
	}
	
	@PostMapping("/novo")
	public String novo() {
		return "formulario";
	}
	
	

}
