package br.com.alura.srtch.controller;

import br.com.alura.srtch.dto.ClienteDTO;
import br.com.alura.srtch.mapper.ClienteMapper;
import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("cliente")
public class NovoClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("novoCliente")
    public String novoCliente(){
        return "cliente/novoCliente";
    }

    @PostMapping("cadastrar")
    public String cadastrar(ClienteDTO clienteDTO){

        Cliente cliente = new ClienteMapper().cadastrar(clienteDTO);
        clienteRepository.save(cliente);

        return "clientes";
    }

    public void cadastrarDTO(List<ClienteDTO> clienteDTOList){
        List<Cliente> clientes = new ClienteMapper().cadastrar(clienteDTOList);
        clienteRepository.saveAll(clientes);
    }

}
