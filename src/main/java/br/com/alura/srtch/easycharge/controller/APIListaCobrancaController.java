package br.com.alura.srtch.easycharge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.srtch.easycharge.dto.CobrancaDTO;
import br.com.alura.srtch.easycharge.modelo.Cobranca;
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
}
