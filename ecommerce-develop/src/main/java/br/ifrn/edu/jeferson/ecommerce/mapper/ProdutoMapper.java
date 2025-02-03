package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.Pedido;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoResponseDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;


@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ItemPedidoMapper.class}
)
public interface ProdutoMapper {
    @Mapping(target = "clienteId", source = "cliente.id")
    PedidoResponseDTO toResponseDTO(Pedido pedido);

    default Page<PedidoResponseDTO> toPageDTO(Page<Pedido> pedidos) {
        return pedidos.map(this::toResponseDTO);
    }
}
