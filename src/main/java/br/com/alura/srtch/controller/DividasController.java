package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.DividaWebDto;
import br.com.alura.srtch.form.AtualizacaoWebClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.form.DividaForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.mapper.DividaMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.model.Divida;
import br.com.alura.srtch.repository.ClienteRepository;
import br.com.alura.srtch.repository.DividaRepository;
import br.com.alura.srtch.service.ValorDaDividaInvalido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

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

    //TODO mudar os nomes, tirar verbos, colocar substantivos na url


    //TODO mudar para delete /clientes/{id}
    @GetMapping("/dividas/remover/{id}")
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

    @PostMapping("/dividas/novo")
    public String cadastrar(@Valid DividaForm dividaForm, BindingResult result){
        if(result.hasErrors()){
            return FORM_DIVIDA;
        }
        Cliente cliente = clienteRepository.findById(dividaForm.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id do cliente não encontrado"));
        if (ValorDaDividaInvalido.validar(dividaForm.getValor(), cliente, dividaRepository)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor das dívidas supera 12x a renda do cliente");
        }

        Divida divida = new DividaMapper().cadastrar(dividaForm, cliente);
        dividaRepository.save(divida);

        return REDIRECT_DIVIDAS;
    }

    //todo passar os dados do cliente para o clienteDTO
    @GetMapping("/dividas/formularioAtualizacao/{id}")
    public String alteraCliente(@PathVariable Long id, AtualizacaoWebClienteForm atualizacaoWebClienteForm){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().toString();
        }

        Cliente cliente = clienteRepository.getById(id);
        atualizacaoWebClienteForm.converter(cliente);

        return "dividas/formularioAtualizacao";
    }

    //todo validar no back
    @PostMapping("/dividas/atualiza")
    @Transactional
    public String atualizar(@Valid AtualizacaoWebClienteForm form, BindingResult result) {
        if(result.hasErrors()){
            return "dividas/formularioAtualizacao";
        }
        new ClienteMapper().atualizar(clienteRepository, form);

        return REDIRECT_DIVIDAS;
    }
}
