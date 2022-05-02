package br.com.alura.strch.servico.DTO;

import br.com.alura.strch.dominio.Endereco;
import br.com.alura.strch.servico.mapper.EntityMepper;
import org.mapstruct.Mapper;

@Mapper
public interface EnderecoMapper extends EntityMepper<EnderecoDTO, Endereco> {
}
