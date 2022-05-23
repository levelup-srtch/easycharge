package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDto;
import br.com.alura.srtch.form.AtualizacaoWebClienteForm;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
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
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";
    private static final String FORM_CLIENTE = "clientes/formulario";
    private static final String FORM_ALTERA_CLIENTE = "clientes/formulario";

    @GetMapping("/clientes")
    public String listarCliente(Model model){

        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC, "dadosPessoais.nome")));

        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    //TODO mudar os nomes, tirar verbos, colocar substantivos na url

    //TODO mudar para patch ou put /clientes/{id}
    @GetMapping("/clientes/status/{id}")
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

    //TODO mudar para delete /clientes/{id}
    @GetMapping("/clientes/remover/{id}")
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

    //todo passar os dados do cliente para o clienteDTO
    @GetMapping("/clientes/formularioAtualizacao/{id}")
    public String alteraCliente(@PathVariable Long id, AtualizacaoWebClienteForm atualizacaoWebClienteForm){
        if(!clienteRepository.existsById(id)){
            return ResponseEntity.notFound().toString();
        }

        Cliente cliente = clienteRepository.getById(id);
        atualizacaoWebClienteForm.converter(cliente);

        return "clientes/formularioAtualizacao";
    }

    //todo validar no back
    @Transactional
    @PostMapping("/clientes/altera")
    public String altera(@Valid AtualizacaoWebClienteForm form, BindingResult result) {
        if(result.hasErrors()){
            return "clientes/formularioAtualizacao";
        }

        Cliente cliente = clienteRepository.getById(form.getId());
        new ClienteMapper().alterar(cliente, form);

        return REDIRECT_CLIENTES;
    }

    @GetMapping("/api/aW52YWxpZGEgcmVsYXTDs3JpbyBkZSBjbGllbnRlcw")
    @CacheEvict(value = "listaDeClientes", allEntries = true)
    public String invalidaCache(){
        return "redirect:/api/clientes/report";
    }

}
