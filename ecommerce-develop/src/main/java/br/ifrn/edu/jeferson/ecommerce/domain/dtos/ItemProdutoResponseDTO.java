package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta de cada item do pedido")
public class ItemProdutoResponseDTO {

    @NotNull(message = "O produto não pode ser nulo")
    @Schema(description = "Detalhes do produto associado ao item do pedido")
    private ProdutoResponseDTO produto;

    @Schema(description = "Quantidade do produto no pedido", example = "14")
    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    @NotNull(message = "A quantidade não pode ser nula")
    private Integer quantidade;
}
