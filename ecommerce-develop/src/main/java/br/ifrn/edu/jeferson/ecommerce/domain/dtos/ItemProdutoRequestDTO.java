package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para requisição de criação de itens de um pedido")
public class ItemProdutoRequestDTO {

    @Schema(description = "Id do produto", example = "14")
    @NotBlank(message = "Obrigatório")
    Long produtoId;

    @Schema(description = "A quantidade do produto especificado pelo id do produto", example = "14")
    @NotNull(message = "A quantidade não pode ser vazia")
    @Min(value = 1, message = "A quantidade do produto tem que ser >= 1")
    Integer quantidade;
}
