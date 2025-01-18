package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotBlank;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO criar pedido")
public class PedidoRequestDTO {
    @Schema(description = "Id do cliente no qual pertence o pedido", example = "15")
    @NotBlank(message = "Id obrigatório")
    Long clienteId;

    @NotEmpty(message = "O pedido deve ter pelo menos um produto e sua quantidade")
    @Valid
    List<ItemPedidoRequestDTO> itens;

    @Schema(hidden = true)
    public List<Long> getProdutosIds() {
        return itens.stream().map(itemPedido -> itemPedido.getProdutoId()).toList();
    }
}