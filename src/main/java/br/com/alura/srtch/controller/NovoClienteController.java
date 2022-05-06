package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cliente")
public class NovoClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String REDIRECT_CLIENTES = "redirect:/clientes";

    private static final String FORM_CLIENTE = "cliente/novoCliente";

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

        return "cliente/alteraCliente";
    }

    @PostMapping("/atualizar")
    public String atualizar(ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.getById(clienteDTO.getId());

        ClienteMapper mapper = new ClienteMapper();
        cliente = mapper.alterar(cliente, clienteDTO);

        clienteRepository.save(cliente);
        return "redirect:/clientes";
    }

}
