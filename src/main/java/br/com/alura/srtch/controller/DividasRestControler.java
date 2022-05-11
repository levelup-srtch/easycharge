package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaDTO;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/dividas")
public class DividasRestControler {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DividaRepository dividaRepository;

    @GetMapping
    public List<DividaDTO> lista(String nome){
        List<Divida> dividas = dividaRepository.findAll();
        return DividaDTO.converter(dividas);
    }

    @PostMapping
    public ResponseEntity<DividaDTO> cadastrar(@RequestBody @Valid DividaForm form, UriComponentsBuilder uriBuilder){
        Divida divida = new DividaMapper().cadastrar(form, clienteRepository);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaDTO());
    }

}
