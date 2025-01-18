package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO usado para representar um produto na listagem por categoria")
public class ProdutosPorCategoriaResponseDTO {
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
}