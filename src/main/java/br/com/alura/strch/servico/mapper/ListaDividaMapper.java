package br.com.alura.strch.servico.mapper;

import br.com.alura.strch.dominio.Divida;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class})
public interface ListaDividaMapper extends EntityMepper<ListaDividaMapper, Divida> {
}
