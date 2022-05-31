package br.com.alura.srtch.easycharge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.srtch.easycharge.repository.ClienteRepository;

@RestController
 // @RequestMapping("/")
public class InvalidateCache {
	

	@Autowired
	private ClienteRepository clienterepository;

	@GetMapping("api/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSBjbGllbnRlcw")
	@CacheEvict(value = "listaClientes", allEntries = true)
	public String invalidate ( ) {	
	return "invalidate cache on!";
	}
	
	

}
