package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.form.ClienteForm;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";
    private static final String FORM_CLIENTE = "novoCliente";
    private static final String FORM_ALTERA_CLIENTE = "alteraCliente";

    @GetMapping("/clientes")
    public String listarCliente(Model model){

        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC, "dadosPessoais.nome")));

        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    //todo mudar os nomes, tirar verbos, colocar substantivos

    @Transactional
    @GetMapping("/clientes/alterarStatus/{id}")
    public String alterarStatus(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getById(id);
        cliente.alteraStatus();

        return REDIRECT_CLIENTES;
    }

    @GetMapping("/clientes/remover/{id}")
    public String removerCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return REDIRECT_CLIENTES;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return REDIRECT_CLIENTES;
    }

    @GetMapping("/clientes/novoCliente")
    public String novoCliente(br.com.alura.srtch.form.ClienteForm clienteForm){
        return FORM_CLIENTE;
    }

    @PostMapping("/clientes/cadastrar")
    public String cadastrar(@Valid ClienteForm clienteForm, BindingResult result){
        if(result.hasErrors()){
            return FORM_CLIENTE;
        }

        Cliente cliente = new ClienteMapper().cadastrar(clienteForm);
        clienteRepository.save(cliente);

        return REDIRECT_CLIENTES;
    }

    //todo para adicionar os clientes do arquivo json
    public void cadastrarDTO(@Valid List<ClienteForm> clienteFormList){
        List<Cliente> clientes = new ClienteMapper().cadastrar(clienteFormList);
        clientes.forEach(cliente -> clienteRepository.save(cliente));
    }

    //todo passar os dados do cliente para o clienteDTO
    @GetMapping("/clientes/alteraCliente/{id}")
    public String alteraCliente(@PathVariable Long id, ClienteDTO clienteDTO, Model model){
        Cliente cliente = clienteRepository.getById(id);

        model.addAttribute("cliente", cliente);

        return "alteraCliente";
    }

    //todo validar no back
    @Transactional
    @PostMapping("/clientes/atualizar")
    public String atualizar(@Valid ClienteDTO clienteDTO, BindingResult result) {
        if(result.hasErrors()){
            return FORM_ALTERA_CLIENTE;
        }

        Cliente cliente = clienteRepository.getById(clienteDTO.getId());
        new ClienteMapper().alterar(cliente, clienteDTO);

        return REDIRECT_CLIENTES;
    }

}
