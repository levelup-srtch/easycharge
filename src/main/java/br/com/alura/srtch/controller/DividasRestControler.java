package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaDto;
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
    public List<DividaDto> lista(){
        List<Divida> dividas = dividaRepository.findAll();
        return DividaDto.converter(dividas);
    }

    @PostMapping
    public ResponseEntity<DividaDto> cadastrar(@RequestBody @Valid DividaForm form, UriComponentsBuilder uriBuilder){
        if(!clienteRepository.existsById(form.getIdCliente())){
            System.out.println("id não encontrado");
            return ResponseEntity.notFound().build();
        }

        Divida divida = new DividaMapper().cadastrar(form, clienteRepository);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaDto(divida));
    }

}
