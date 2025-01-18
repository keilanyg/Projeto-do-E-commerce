package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta do produto de um pedido")
public class ItemPedidoProdutoResponseDTO {
    @Schema(example = "8")
    private Long id;

    @Schema(example = "Water Cooler")
    private String nome;
}
