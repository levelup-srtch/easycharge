package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.CobrancaDto;
import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.mapper.CobrancaMapper;
import br.com.alura.srtch.model.Cobranca;
import br.com.alura.srtch.repository.CobrancaRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cobrancas")
public class CobrancasRestController {

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private DividaRepository dividaRepository;

    @GetMapping
    public List<CobrancaDto> lista() {
        List<Cobranca> cobrancas = cobrancaRepository.findAll();
        return CobrancaDto.converter(cobrancas);
    }

    @PostMapping
    public ResponseEntity<CobrancaDto> cadastrar(@RequestBody @Valid CobrancaForm form, UriComponentsBuilder uriBuilder) {
        if (!dividaRepository.existsById(form.getIdDivida())) {
            System.out.println("id não encontrado");
            //todo .body ou response body exception
            return ResponseEntity.badRequest().build();
        }

        Cobranca cobranca = new CobrancaMapper().cadastrar(form, cobrancaRepository, dividaRepository);

        cobrancaRepository.save(cobranca);

        URI uri = uriBuilder.path("/api/cobrancas/{id}").buildAndExpand(cobranca.getId()).toUri();
        return ResponseEntity.created(uri).body(new CobrancaDto(cobranca));
    }

}
