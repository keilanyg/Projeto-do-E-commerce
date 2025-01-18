package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO de resposta de um produto")
public class ProdutoResponseDTO {
    @Schema(example = "1")
    private Long id;

    @Schema(example = "Projetor Data Show")
    private String nome;

    @Schema(example = "Mini Projetor Wifi Portátil 5G Android")
    private String descricao;

    @Schema(example = "234.00")
    private BigDecimal preco;

    @Schema(example = "15")
    private Integer estoque;
    private List<CategoriaResponseDTO> categorias;
}