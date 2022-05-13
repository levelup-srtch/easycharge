package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDto;
import br.com.alura.srtch.dto.ClientesResponseDto;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.projection.RelatorioClientesProjecao;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesRestControler {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Page<ClientesResponseDto> lista(Integer page){
        if(page == null){
            page = 0;
        }
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "status")
                .and(Sort.by(Sort.Direction.ASC, "dadosPessoais.nome")));
        return clienteRepository.findAll(pageable).map(ClientesResponseDto::new);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = new ClienteMapper().cadastrar(form);
        clienteRepository.save(cliente);

        URI uri = uriBuilder.path("/api/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @GetMapping("/report")
    public List<RelatorioClientesProjecao> listarReport(){
        return clienteRepository.findNomeValorDasDividasCobrancas();
    }

}
