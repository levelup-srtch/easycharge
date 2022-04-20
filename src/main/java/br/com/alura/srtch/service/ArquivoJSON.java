package br.com.alura.srtch.service;

import br.com.alura.srtch.modelo.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoJSON {

    private List<Cliente> clientes;

    public List<Cliente> retornaArquivoJSON(String arquivo){
        try {
            Reader reader = new FileReader(arquivo);
            ObjectMapper mapper = new ObjectMapper();

            this.clientes = mapper.readValue(reader, new TypeReference<>() {
            });
        } catch (
                IOException ex) {
            throw new IllegalStateException(ex);
        }
        return this.clientes;
    }
}
