package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoCSV implements Arquivo {

    @Override
    public List<ClienteDTO> arquivo(String arquivo) {
        List<ClienteDTO> rcda;
        try {
            Reader reader = new FileReader(arquivo);
            CsvToBean<ClienteDTO> csvToBean = new CsvToBeanBuilder<ClienteDTO>(reader)
                    .withType(ClienteDTO.class)
                    .build();
            rcda = csvToBean.parse();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return rcda;
    }
}
