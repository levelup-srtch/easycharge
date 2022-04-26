package br.com.alura.srtch.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import br.com.alura.srtch.modelo.Cliente;

public class ArquivoCSV {

	public List<Cliente> Ler(String arquivo) {
		List<Cliente> clientes;
      try {
        Reader reader = new FileReader(arquivo);
        CsvToBean<Cliente> csvToBean = new CsvToBeanBuilder<Cliente>(reader)
            .withType(Cliente.class)
            .build();
        clientes = csvToBean.parse();
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }
      return clientes;
    } 
}
