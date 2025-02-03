package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para requisição de criação de itens de um pedido")
public class ItemPedidoRequestDTO {

    @Schema(description = "Id do produto no pedido", example = "8")
    @NotNull(message = "O ID do produto é obrigatório")
    private Long produtoId;  // ID do produto que será adicionado ao pedido

    @Schema(description = "A quantidade do produto", example = "2")
    @NotNull(message = "A quantidade do produto é obrigatória")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    private Integer quantidade;  // Quantidade do produto

    @Schema(description = "O preço unitário do produto", example = "150.75")
    @NotNull(message = "O preço do produto é obrigatório")
    private BigDecimal precoUnitario;  // Preço unitário do produto no pedido (não pode ser negativo)
}
