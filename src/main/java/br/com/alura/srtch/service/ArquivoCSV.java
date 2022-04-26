package br.com.alura.srtch.service;

import br.com.alura.srtch.dto.ClienteDoArquivo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoCSV implements Arquivo {

    @Override
    public List<ClienteDoArquivo> arquivo(String arquivo) {
        List<ClienteDoArquivo> rcda;
        try {
            Reader reader = new FileReader(arquivo);
            CsvToBean<ClienteDoArquivo> csvToBean = new CsvToBeanBuilder<ClienteDoArquivo>(reader)
                    .withType(ClienteDoArquivo.class)
                    .build();
            rcda = csvToBean.parse();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return rcda;
    }
}
