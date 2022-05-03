package br.com.alura.strch.servico;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.repositorio.DividaRepositorio;
import br.com.alura.strch.servico.DTO.DividaDTO;
import br.com.alura.strch.servico.DTO.SelectDTO;
import br.com.alura.strch.servico.excecao.ObjectnotFoundException;
import br.com.alura.strch.servico.filtro.DividaFiltro;
import br.com.alura.strch.servico.mapper.DividaMapper;
import br.com.alura.strch.servico.mapper.DividaSetcMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class DividaServico implements Serializable {

    private final DividaRepositorio dividaRepositorio;
    private final DividaMapper dividaMapper;
    private final DividaSetcMapper dividaSetcMapper;

    public DividaDTO encontrarPorId(Long id){
        Divida divida = dividaRepositorio.findById(id).orElseThrow(()-> new ObjectnotFoundException("divida não encontrada!" + id));
        return dividaMapper.toDTO(divida);
    }

    public List<DividaDTO> buscarTodas(){
        return dividaMapper.toDTO(dividaRepositorio.OrderByDate());
    }

    public boolean validadorDivida (DividaDTO dividaDTO){
        if(!dividaRepositorio.existsByDataAbertura(dividaDTO.getDataAbertura())){
            return true;
        }
        throw new ObjectnotFoundException("Essa divida já esta em ABERTO!!" + dividaDTO.getDescricao());
    }


    public DividaDTO salvar (DividaDTO dividaDTO){
        if(validadorDivida(dividaDTO)){
            Divida divida = dividaMapper.toEntity(dividaDTO);
            Divida dividaSalvar = dividaRepositorio.save(divida);
            return dividaMapper.toDTO(dividaSalvar);
        }
        throw new ObjectnotFoundException("divida esta em Aberto!!" + dividaDTO.getDescricao());
    }

    public DividaDTO editar(DividaDTO dividaDTO){
        Divida divida = dividaMapper.toEntity(dividaDTO);
        Divida dividaAtualizar = dividaRepositorio.save(divida);
        return dividaMapper.toDTO(dividaAtualizar);
    }

    public void excluirDivida(Long id){
        dividaRepositorio.deleteById(id);
    }

    public List<DividaDTO> buscarPorFiltros(DividaFiltro dividaFiltro){
        return dividaMapper.toDTO(dividaRepositorio.findAll(dividaFiltro.filter()));
    }
}
