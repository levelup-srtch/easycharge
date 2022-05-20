package br.com.alura.srtch.easycharge.controller;

import java.net.URI;
import java.util.List;

import javax.persistence.Cacheable;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.srtch.easycharge.dto.DividaDTO;
import br.com.alura.srtch.easycharge.form.DividaForm;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;
import br.com.alura.srtch.easycharge.repository.DividaRepository;

//@Controller
@RestController
@RequestMapping("/api/dividas")
public class APIListaDividaController {
	
	@Autowired
	private DividaRepository dividarepository;
	
	@Autowired
	private ClienteRepository clienterepository;
	/*
	@RequestMapping("/api/listaclientes")
	@ResponseBody
	public List<Cliente> home(Model model) { 
	//public List<List<Cliente>> home(Model model) { // para rDividaFormum array com varias listas de clientes
		List<Cliente> clientes = dividarepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("clientes", clientes);
		// return Arrays.asList(clientes,clientes,clientes); // para retornar um array com varias listas de clientes
		   return (clientes);
	}
	*/
	
	@GetMapping
	@org.springframework.cache.annotation.Cacheable(value = "listaClientes")
	//@ResponseBody
	 // public List<DividaDTO> home2(Model model) { 
	 public List<DividaDTO> listaDivida()  { 
		List<Divida> dividas = dividarepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		//model.addAttribute("clientes", clientes);
		   return DividaDTO.converte(dividas);
		
			
		}
	
	
	 @PostMapping
	 @Transactional
	 @CacheEvict(value = "listaClientes", allEntries = true)
	 public ResponseEntity<DividaDTO> cadastrar(@RequestBody @Valid DividaForm requisicao, UriComponentsBuilder uriBuilder){
		 if(! clienterepository.existsById(requisicao.getIdCliente())){
	            System.out.println("id não encontrado");
	            return ResponseEntity.badRequest().build();
		 } else {
 		 Divida divida = requisicao.toDivida();
		 dividarepository.save(divida);
		 
		 
		
		 URI uri = uriBuilder.path("divida/{id}").buildAndExpand(divida.getId()).toUri();
		 return ResponseEntity.created(uri).body(new DividaDTO(divida));
		 }
	 }
}
