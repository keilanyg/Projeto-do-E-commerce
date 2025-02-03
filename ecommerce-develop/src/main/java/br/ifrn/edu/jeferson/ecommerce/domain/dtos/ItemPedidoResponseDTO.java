package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta do produto de um pedido")
public class ItemPedidoResponseDTO {

    @Schema(example = "8")
    private Long id;

    @Schema(example = "Water Cooler")
    private String nome;

    @Schema(example = "150.75")
    private BigDecimal precoUnitario;  // Usando BigDecimal para representar valores monetários

    @Schema(example = "2")
    private Integer quantidade;  // Quantidade do produto no pedido
}
