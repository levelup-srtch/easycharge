package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteWebDto;
import br.com.alura.srtch.form.AtualizacaoClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";
    private static final String FORM_CLIENTE = "clientes/formulario";
    @GetMapping("/clientes")
    public String listarCliente(@PageableDefault(sort = {"status", "dadosPessoais.nome"},
            direction = Sort.Direction.ASC) Pageable pageable, Model model){

        Page<Cliente> clientes = clienteRepository.findAll(pageable);
        Page<ClienteWebDto> clientesResponse = ClienteWebDto.converter(clientes);

        model.addAttribute("clientes", clientesResponse);

        return "clientes";
    }


    @PatchMapping("/clientes/{id}")
    @Transactional
    public String alterarStatus(@PathVariable Long id) {
        if(!clienteRepository.existsById(id)){
            System.out.println("id não encontrado");
            return ResponseEntity.notFound().toString();
        }

        Cliente cliente = clienteRepository.getById(id);
        cliente.alteraStatus();

        return REDIRECT_CLIENTES;
    }

    @DeleteMapping("/clientes/{id}")
    public String removerCliente(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            System.out.println("id não encontrado");
            return ResponseEntity.notFound().toString();
        }

        clienteRepository.deleteById(id);
        return REDIRECT_CLIENTES;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return REDIRECT_CLIENTES;
    }

    @GetMapping("/clientes/formulario")
    public String novoCliente(ClienteForm clienteForm){
        return FORM_CLIENTE;
    }

    @PostMapping("/clientes/novo")
    public String cadastrar(@Valid ClienteForm clienteForm, BindingResult result){
        if(result.hasErrors()){
            return FORM_CLIENTE;
        }

        Cliente cliente = new ClienteMapper().cadastrar(clienteForm);
        clienteRepository.save(cliente);

        return REDIRECT_CLIENTES;
    }

    @GetMapping("/clientes/edit/{id}")
    public String alterarCliente(@PathVariable Long id, AtualizacaoClienteForm atualizacaoWebClienteForm){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().toString();
        }

        Cliente cliente = clienteRepository.getById(id);
        atualizacaoWebClienteForm.converter(cliente);

        return "clientes/formularioAtualizacao";
    }

    @PutMapping("/clientes")
    @Transactional
    public String atualizar(@Valid AtualizacaoClienteForm form, BindingResult result) {
        if(result.hasErrors()){
            return "clientes/formularioAtualizacao";
        }
        new ClienteMapper().atualizar(clienteRepository, form);

        return REDIRECT_CLIENTES;
    }

    @GetMapping("/api/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSBjbGllbnRlcw")
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    public String invalidarCache(){
        return "redirect:/api/clientes/report";
    }

}
