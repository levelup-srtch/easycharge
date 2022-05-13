package br.com.alura.srtch.easycharge.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.srtch.easycharge.dto.DividaDTO;
import br.com.alura.srtch.easycharge.form.DividaForm;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.repository.DividaRepository;

//@Controller
@RestController
@RequestMapping("/api/divida")
public class APIListaDividaController {
	
	@Autowired
	private DividaRepository dividarepository;
	
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
	//@ResponseBody
	 // public List<DividaDTO> home2(Model model) { 
	 public List<DividaDTO> home(Model model)  { 
		List<Divida> dividas = dividarepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		//model.addAttribute("clientes", clientes);
		   return DividaDTO.converte(dividas);
		
			
		}
	
	
	 @PostMapping
	 @Transactional
	 public ResponseEntity<DividaDTO> cadastrar(@RequestBody @Valid DividaForm requisicao, UriComponentsBuilder uriBuilder){
	     
		
		 Divida divida = requisicao.toDivida();
		 dividarepository.save(divida);
		
		 URI uri = uriBuilder.path("divida/{id}").buildAndExpand(divida.getIdDivida()).toUri();
		 return ResponseEntity.created(uri).body(new DividaDTO(divida));
	 }
	
}
