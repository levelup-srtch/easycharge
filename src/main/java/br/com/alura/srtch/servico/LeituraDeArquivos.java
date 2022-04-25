package br.com.alura.srtch.servico;

import br.com.alura.srtch.dominio.Cliente;
import br.com.alura.srtch.dominio.Endereco;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class LeituraDeArquivos {

    public List<Cliente> lerArquivo(String arquivo) {

        List<Cliente> clientes;
        List<Endereco> enderecos;

        if (arquivo.endsWith(".csv")) {
            try {
                Reader reader = new FileReader(arquivo);
                CsvToBean<Cliente> csvToBean = new CsvToBeanBuilder<Cliente>(reader)
                        .withType(Cliente.class)
                        .build();
                clientes = csvToBean.parse();
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        } else if (arquivo.endsWith(".json")) {
            try {
                Reader reader = new FileReader(arquivo);
                ObjectMapper mapper = new ObjectMapper();

                clientes = mapper.readValue(reader, new TypeReference<>() {
                });
            } catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        } else {
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
        return clientes;
    }
}
