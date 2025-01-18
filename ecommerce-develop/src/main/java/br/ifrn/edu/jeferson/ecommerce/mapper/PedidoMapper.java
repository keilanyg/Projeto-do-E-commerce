package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.Produto;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutoPartialRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.ProdutosPorPedidoResponseDTO;

import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ItemPedidoMapper.class}
)
public interface PedidoMapper {

    PedidoResponseDTO toResponseDTO(Pedido pedido);

    // Converter DTO para Pedido
    @Mapping(target = "clienteId", source = "cliente.id")

    default Page<PedidoResponseDTO> toPageDTO(Page<Pedido> pedidos) {
        return pedidos.map(this::toResponseDTO);
    }
}
