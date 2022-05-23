package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.repositorio.DividaRepositorio;
import br.com.alura.strch.servico.DTO.DividaDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.mapper.DividaMapper;
import br.com.alura.strch.servico.mapper.DividaSetcMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@RequiredArgsConstructor
@Transactional
@Service
public class DividaServico implements Serializable {

    private final DividaRepositorio dividaRepositorio;
    private final DividaMapper dividaMapper;
    private final DividaSetcMapper dividaSetcMapper;

    public DividaDTO encontrarPorId(Long id){
        Divida divida = dividaRepositorio.findById(id).orElseThrow(ObjectnotFoundException::new);
        return dividaMapper.toDTO(divida);
    }



}
