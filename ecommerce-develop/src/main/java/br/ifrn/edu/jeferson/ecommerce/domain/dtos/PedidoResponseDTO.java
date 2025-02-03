package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.List;

import br.ifrn.edu.jeferson.ecommerce.domain.enums.StatusPedido;
import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO que representa um pedido")
public class PedidoResponseDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "2024-12-28T20:00:53")
    private LocalDateTime dataPedido;

    @Schema(example = "79.90")
    private BigDecimal valorTotal;

    @Schema(example = "Analisando")
    private StatusPedido statusPedido;

    @Schema(example = "15")
    private Long clienteId;
    
    private List<ItemPedidoResponseDTO> itens;
}
