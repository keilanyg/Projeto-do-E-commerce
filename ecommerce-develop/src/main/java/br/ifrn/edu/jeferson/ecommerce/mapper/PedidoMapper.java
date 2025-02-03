package br.ifrn.edu.jeferson.ecommerce.mapper;

import br.ifrn.edu.jeferson.ecommerce.domain.Pedido;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.PedidoResponseDTO;
import org.springframework.data.domain.Page;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ItemPedidoMapper.class}
)
public interface PedidoMapper {

    // Método para converter Pedido para PedidoResponseDTO
    PedidoResponseDTO toResponseDTO(Pedido pedido);

    // Método para converter PedidoRequestDTO para Pedido
    @Mapping(target = "cliente.id", source = "clienteId")
    Pedido toEntity(PedidoRequestDTO pedidoRequestDTO);

    // Converter a página de pedidos para uma página de PedidoResponseDTO
    default Page<PedidoResponseDTO> toPageDTO(Page<Pedido> pedidos) {
        return pedidos.map(this::toResponseDTO);
    }

    // Método para converter uma lista de Pedido para uma lista de PedidoResponseDTO
    List<PedidoResponseDTO> toDTOList(List<Pedido> pedidos);
}
