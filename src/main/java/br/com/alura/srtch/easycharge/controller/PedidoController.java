package br.com.alura.srtch.easycharge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.srtch.easycharge.dto.RequisicaoNovoCliente;
import br.com.alura.srtch.easycharge.modelo.Cliente;


@Controller
//@RequestMapping("pedido")
public class PedidoController {

	@GetMapping("/formulario")
	public String formulario () {
		return "formulario";
	
	}
	
	@PostMapping("/novo")
	public String novo(RequisicaoNovoCliente requisicao) {
		Cliente cliente = requisicao.toCliente();
		return "formulario";
	}
	
	

}
