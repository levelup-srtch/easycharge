package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.CobrancaDto;
import br.com.alura.srtch.form.CobrancaForm;
import br.com.alura.srtch.mapper.CobrancaMapper;
import br.com.alura.srtch.model.Cobranca;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.CobrancaRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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
        Divida divida = dividaRepository.findById(form.getIdDivida())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id da dívida não encontrado"));

        Cobranca cobranca = new CobrancaMapper().cadastrar(form, cobrancaRepository, divida);

        cobrancaRepository.save(cobranca);

        URI uri = uriBuilder.path("/api/cobrancas/{id}").buildAndExpand(cobranca.getId()).toUri();
        return ResponseEntity.created(uri).body(new CobrancaDto(cobranca));
    }

}
