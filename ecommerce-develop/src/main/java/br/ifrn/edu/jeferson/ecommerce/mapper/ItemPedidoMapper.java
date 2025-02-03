package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.ItemPedido;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ItemPedidoResponseDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    @Mapping(source = "produto.nome", target = "nome")   // Acessa 'nome' de 'produto'
    @Mapping(source = "produto.preco", target = "preco")  // Acessa 'preco' de 'produto'
    List<ItemPedidoResponseDTO> toDTOList(List<ItemPedido> itemPedidos);
}
