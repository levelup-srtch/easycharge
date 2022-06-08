package br.com.alura.srtch.api;

import br.com.alura.srtch.dto.DividaComCpfDTO;
import br.com.alura.srtch.dto.DividaDto;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import br.com.alura.srtch.service.ValorDaDividaInvalido;
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
@RequestMapping("/api/dividas")
@CrossOrigin
public class DividasRestController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DividaRepository dividaRepository;

    @GetMapping
    public List<DividaDto> lista(){
        List<Divida> dividas = dividaRepository.findAll();
        return DividaDto.converter(dividas);
    }

    @GetMapping("/cpf")
    public List<DividaComCpfDTO> listarComCpf(){
        List<Divida> dividas = dividaRepository.findAll();
        return DividaComCpfDTO.converter(dividas);
    }

    @PostMapping
    public ResponseEntity<DividaDto> cadastrar(@RequestBody @Valid DividaForm form, UriComponentsBuilder uriBuilder){
        Cliente cliente = clienteRepository.findById(form.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id do cliente não encontrado"));
        if (ValorDaDividaInvalido.validar(form.getValor(), cliente, dividaRepository)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor das dívidas supera 12x a renda do cliente");
        }
        Divida divida = new DividaMapper().cadastrar(form, cliente);
        dividaRepository.save(divida);

        URI uri = uriBuilder.path("/api/dividas/{id}").buildAndExpand(divida.getId()).toUri();
        return ResponseEntity.created(uri).body(new DividaDto(divida));
    }

}
