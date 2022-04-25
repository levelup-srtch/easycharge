package br.com.alura.srtch.service;

import br.com.alura.srtch.vo.RecebeClienteDoArquivo;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ArquivoCSV implements RetornaArquivo{

    @Override
    public List<RecebeClienteDoArquivo> RecebeArquivo(String arquivo) {
        List<RecebeClienteDoArquivo> rcda;
        try {
            Reader reader = new FileReader(arquivo);
            CsvToBean<RecebeClienteDoArquivo> csvToBean = new CsvToBeanBuilder<RecebeClienteDoArquivo>(reader)
                    .withType(RecebeClienteDoArquivo.class)
                    .build();
            rcda = csvToBean.parse();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        return rcda;
    }
}
