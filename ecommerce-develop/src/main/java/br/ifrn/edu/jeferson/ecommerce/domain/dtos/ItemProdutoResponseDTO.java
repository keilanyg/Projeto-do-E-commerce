package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta de cada item do pedido")
public class ItemProdutoResponseDTO {
    private ItemPedidoProdutoResponseDTO produto;

    @Schema(example = "14")
    private Integer quantidade;
}
