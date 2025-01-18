package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.Pedido;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoResponseDTO;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ItemPedidoMapper.class}
)
public interface PedidoMapper {
    @Mapping(target = "clienteId", source = "cliente.id")
    PedidoResponseDTO toResponseDTO(Pedido pedido);

    default Page<PedidoResponseDTO> toPageDTO(Page<Pedido> pedidos) {
        return pedidos.map(this::toResponseDTO);
    }
}
