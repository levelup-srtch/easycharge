package br.com.alura.srtch.controller;

import br.com.alura.srtch.api.DividasRestController;
import br.com.alura.srtch.dto.DividaWebDto;
import br.com.alura.srtch.form.AtualizacaoClienteForm;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DividasController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DividaRepository dividaRepository;

    private static final String REDIRECT_DIVIDAS = "redirect:/dividas";
    private static final String FORM_DIVIDA = "dividas/formulario";
    private static final String FORM_ALTERA_DIVIDA = "dividas/formulario";

    @GetMapping("/dividas")
    public String listarCliente(Model model){

        List<Divida> dividas = dividaRepository.findAll(Sort.by(Sort.Direction.ASC, "cliente_id"));
        List<DividaWebDto> dividaWebDtoList = DividaWebDto.converter(dividas);

        model.addAttribute("dividas", dividaWebDtoList);

        return "dividas";
    }

    @DeleteMapping("/dividas/{id}")
    public String removerCliente(@PathVariable Long id){
        if(!dividaRepository.existsById(id)){
            System.out.println("id não encontrado");
            return ResponseEntity.notFound().toString();
        }

        dividaRepository.deleteById(id);
        return REDIRECT_DIVIDAS;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return REDIRECT_DIVIDAS;
    }

    @GetMapping("/dividas/formulario")
    public String criarDivida(DividaForm dividaForm){
        return FORM_DIVIDA;
    }

    @PostMapping("/dividas")
    public String cadastrar(@Valid DividaForm dividaForm, BindingResult result){
        if(result.hasErrors()){
            return FORM_DIVIDA;
        }
        DividasRestController.verificarCliente(dividaForm, clienteRepository, dividaRepository);

        return REDIRECT_DIVIDAS;
    }
    @GetMapping("/dividas/formularioAtualizacao/{id}")
    public String alterarCliente(@PathVariable Long id, AtualizacaoClienteForm atualizacaoWebClienteForm){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().toString();
        }

        Cliente cliente = clienteRepository.getById(id);
        atualizacaoWebClienteForm.converter(cliente);

        return "dividas/formularioAtualizacao";
    }

    @PutMapping("/dividas")
    @Transactional
    public String atualizar(@Valid AtualizacaoClienteForm form, BindingResult result) {
        if(result.hasErrors()){
            return "dividas/formularioAtualizacao";
        }
        new ClienteMapper().atualizar(clienteRepository, form);

        return REDIRECT_DIVIDAS;
    }
}
