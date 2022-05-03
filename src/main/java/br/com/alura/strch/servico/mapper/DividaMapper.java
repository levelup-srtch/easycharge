package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Divida;
import br.com.alura.strch.servico.DTO.DividaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DividaMapper extends EntityMepper<DividaDTO, Divida> {
}
