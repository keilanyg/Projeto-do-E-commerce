package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para criação de pedido")
public class PedidoRequestDTO {

    @Schema(description = "Id do cliente ao qual pertence o pedido", example = "15")
    @NotNull(message = "O ID do cliente é obrigatório")
    Long clienteId;

    @Schema(description = "Lista de itens do pedido", example = "[{'produtoId': 14, 'quantidade': 2}]")
    @Valid
    @Size(min = 1, message = "O pedido deve ter pelo menos um produto e sua quantidade")
    List<ItemPedidoRequestDTO> itens;
    
    @Schema(hidden = true)
    public List<Long> getProdutosIds() {
        return itens.stream().map(ItemPedidoRequestDTO::getProdutoId).toList();
    }
}
