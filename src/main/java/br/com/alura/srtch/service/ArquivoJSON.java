package br.com.alura.srtch.service;

import br.com.alura.srtch.vo.RecebeClienteDoArquivo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoJSON implements RetornaArquivo{

    @Override
    public List<RecebeClienteDoArquivo> RecebeArquivo(String arquivo) {
        List<RecebeClienteDoArquivo> rcda;
        try {
            Reader reader = new FileReader(arquivo);
            ObjectMapper mapper = new ObjectMapper();

            rcda = mapper.readValue(reader, new TypeReference<>() {
            });
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return rcda;
    }
}
