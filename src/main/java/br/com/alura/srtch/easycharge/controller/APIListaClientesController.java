package br.com.alura.srtch.easycharge.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.srtch.easycharge.dto.ClienteDTO;
import br.com.alura.srtch.easycharge.form.ClienteForm;
import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.projection.RelatorioClientesProjection;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;

//@Controller
@RestController
@RequestMapping("/api/clientes")
public class APIListaClientesController {
	
	@Autowired
	private ClienteRepository clienterepository;
	
	/*
	@RequestMapping("/api/listaclientes")
	@ResponseBody
	public List<Cliente> home(Model model) { 
	//public List<List<Cliente>> home(Model model) { // para retornar um array com varias listas de clientes
		List<Cliente> clientes = clienterepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("clientes", clientes);
		// return Arrays.asList(clientes,clientes,clientes); // para retornar um array com varias listas de clientes
		   return (clientes);
	}
	*/
	
	
	@GetMapping
	//@ResponseBody
	 // public List<ClienteDTO> home2(Model model) { 
	 public List<ClienteDTO> lista(String nome) { 
		//@RequestParam(defaultValue = "0") int page,
        //@RequestParam(defaultValue = "3") int size
		if (nome == null) {
		List<Cliente> clientes = clienterepository.findAll(Sort.by(Sort.Direction.ASC, "nome").and(Sort.by(Sort.Direction.ASC, "status")));
		//model.addAttribute("clientes", clientes);
		   return ClienteDTO.converte(clientes);
		} else {
			List<Cliente> clientes = clienterepository.findByNome(nome);
			return ClienteDTO.converte(clientes);
			
		}
	}
	
	
	
	@GetMapping("/report")
    public List<RelatorioClientesProjection> listarReport(){
        return clienterepository.ClienteDividas();
    }
	
	 @PostMapping
	 public ResponseEntity<ClienteDTO> cadastrar(@RequestBody @Valid ClienteForm requisicao, UriComponentsBuilder uriBuilder){
	           
		 Cliente cliente = requisicao.toCliente();
		 clienterepository.save(cliente);
		
		 URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		 return ResponseEntity.created(uri).body(new ClienteDTO(cliente));
	 }
	
}