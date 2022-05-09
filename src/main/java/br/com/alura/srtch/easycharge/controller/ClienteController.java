package br.com.alura.srtch.easycharge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.srtch.easycharge.dto.RequisicaoNovoCliente;
import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;


@Controller
//@RequestMapping("pedido")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienterepository;

	@GetMapping("/cliente/formulario")
	public String formulario (RequisicaoNovoCliente requisicao) {
		return "formulario";
	
	}
	
	 // aula 5 bin validation
	@PostMapping("/cliente/novo")
	
	public String novo(@Valid RequisicaoNovoCliente requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "formulario";
		} 
		
		Cliente cliente = requisicao.toCliente();
		clienterepository.save(cliente);
		
		return "redirect:/listaclientes";
	}
	
	 @GetMapping("/cliente/delete")
	    public String delete(@RequestParam Long id){
		 	clienterepository.deleteById(id);
	        return "redirect:/listaclientes";
	
	 }
	 
	 

	    @GetMapping("/cliente/alterarStatus")
	    public String alterarStatus(@RequestParam Long id){
	        Cliente cliente = clienterepository.getById(id);
	        cliente.alteracaoStatus(cliente);
	        clienterepository.save(cliente);
	        return "redirect:/listaclientes";
	    }
}
