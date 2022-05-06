package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
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
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";

    private static final String FORM_CLIENTE = "novoCliente";

    @GetMapping("/clientes")
    public String listarCliente(Model model){

        List<Cliente> clientes = clienteRepository.findAll(Sort.by(Sort.Direction.ASC, "status").and(Sort.by(Sort.Direction.ASC, "dadosPessoais.nome")));

        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    @Transactional
    @GetMapping("/alterarStatus/{id}")
    public String alterarStatus(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getById(id);
        cliente.alteraStatus();

        return REDIRECT_CLIENTES;
    }

    @GetMapping("/remover/{id}")
    public String removerCliente(@PathVariable Long id){
        clienteRepository.deleteById(id);
        return REDIRECT_CLIENTES;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return REDIRECT_CLIENTES;
    }

    @GetMapping("/novoCliente")
    public String novoCliente(ClienteDTO clienteDTO){
        return FORM_CLIENTE;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid ClienteDTO clienteDTO, BindingResult result){
        if(result.hasErrors()){
            return FORM_CLIENTE;
        }

        Cliente cliente = new ClienteMapper().cadastrar(clienteDTO);
        clienteRepository.save(cliente);

        return REDIRECT_CLIENTES;
    }

    //todo para adicionar os clientes do arquivo json
    public void cadastrarDTO(@Valid List<ClienteDTO> clienteDTOList){
        List<Cliente> clientes = new ClienteMapper().cadastrar(clienteDTOList);
        clientes.forEach(cliente -> clienteRepository.save(cliente));
    }

    @GetMapping("/alteraCliente/{id}")
    public String alteraCliente(@PathVariable Long id, Model model){
        Cliente cliente = clienteRepository.getById(id);

        model.addAttribute("cliente", cliente);

        return "alteraCliente";
    }

    //todo validar no back
    @Transactional
    @PostMapping("/atualizar")
    public String atualizar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.getById(clienteDTO.getId());

        new ClienteMapper().alterar(cliente, clienteDTO);

        return REDIRECT_CLIENTES;
    }

}
