package br.com.alura.srtch.easycharge.controller;

import java.net.URI;
import java.util.List;

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

import br.com.alura.srtch.easycharge.dto.CobrancaDTO;
import br.com.alura.srtch.easycharge.dto.DividaDTO;
import br.com.alura.srtch.easycharge.form.CobrancaForm;
import br.com.alura.srtch.easycharge.form.DividaForm;
import br.com.alura.srtch.easycharge.modelo.Cobranca;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.repository.ClienteRepository;
import br.com.alura.srtch.easycharge.repository.CobrancaRepository;
import br.com.alura.srtch.easycharge.repository.DividaRepository;

@RestController
@RequestMapping("/api/cobrancas")
public class APIListaCobrancaController {

	@Autowired
	private DividaRepository dividarepository;

	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private CobrancaRepository cobrancarepository;
	
	@GetMapping
	//@org.springframework.cache.annotation.Cacheable(value = "listaClientes")

	 public List<CobrancaDTO> listaCobranca()  { 
		List<Cobranca> cobrancas = cobrancarepository.findAll(Sort.by(Sort.Direction.ASC, "id"));;
		   return CobrancaDTO.converte(cobrancas);
	}
	
	
	 @PostMapping
	 @Transactional
	 @CacheEvict(value = "listaClientes", allEntries = true)
	 public ResponseEntity<CobrancaDTO> cadastrar(@RequestBody @Valid CobrancaForm requisicao, UriComponentsBuilder uriBuilder){
		 if(! dividarepository.existsById(requisicao.getIdDivida())){
	            System.out.println("id não encontrado");
	            return ResponseEntity.badRequest().build();
		 } else {
 		 Cobranca cobranca = requisicao.toCobranca();
 		cobrancarepository.save(cobranca);
		 
		 
		
		 URI uri = uriBuilder.path("cobranca/{id}").buildAndExpand(cobranca.getId()).toUri();
		 return ResponseEntity.created(uri).body(new CobrancaDTO(cobranca));
		 }
	 }
	
}
