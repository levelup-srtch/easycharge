package br.com.alura.strch.web.rest;

import br.com.alura.strch.servico.CobrancaServico;
import br.com.alura.strch.servico.DTO.CobrancaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.filtro.CobrancaFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/cobrancas")
public class CobrancaRecurso {

    private final CobrancaServico cobrancaServico;

    @GetMapping(value = "/{id}")
    public ResponseEntity <CobrancaDTO> buscarPorId(@PathVariable long id){
        CobrancaDTO cobrancaDTO = cobrancaServico.encontrarPorId(id);
        return ResponseEntity.ok(cobrancaDTO);
    }

    @GetMapping
    public ResponseEntity <List<CobrancaDTO>> buscarTodos(){
        List<CobrancaDTO> listCobrabca = cobrancaServico.buscarTodos();
        return ResponseEntity.ok(listCobrabca);
    }

    @GetMapping(value="/select")
    public ResponseEntity <List<SelectDTO>> buscarporSelect(){
        List<SelectDTO> selectlist = cobrancaServico.BuscarTodosSelec();
        return ResponseEntity.ok(selectlist);
    }

    @PostMapping
    public ResponseEntity <CobrancaDTO> salvar(@RequestBody CobrancaDTO cobrancaDTO){
        return ResponseEntity.ok(cobrancaServico.salvar(cobrancaDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity <CobrancaDTO> editar(@RequestBody CobrancaDTO cobrancaDTO,@PathVariable Long id){
        cobrancaDTO.setId(id);
        cobrancaDTO = cobrancaServico.editar(cobrancaDTO);
        return ResponseEntity.ok(cobrancaDTO);
    }

    @GetMapping(value = "filtro")
    public ResponseEntity <List<CobrancaDTO>> buscarPorFiltro(CobrancaFiltro cobrancaFiltro){
        return ResponseEntity.ok(cobrancaServico.buscarTodosFiltro(cobrancaFiltro));
    }
}
