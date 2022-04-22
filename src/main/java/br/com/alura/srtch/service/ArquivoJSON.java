package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoJSON implements RetornaArquivo{

    @Override
    public List<Cliente> RecebeArquivo(String arquivo) {
        List<Cliente> clientes;
        try {
            Reader reader = new FileReader(arquivo);
            ObjectMapper mapper = new ObjectMapper();

            clientes = mapper.readValue(reader, new TypeReference<>() {
            });
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return clientes;
    }
}
