package br.com.alura.srtch.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.srtch.modelo.Cliente;

public class ArquivoJSON {

	public List<Cliente> Ler(String arquivo) {
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

