package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.servico.DTO.EnderecoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper extends EntityMepper<EnderecoDTO, Endereco> {
}
