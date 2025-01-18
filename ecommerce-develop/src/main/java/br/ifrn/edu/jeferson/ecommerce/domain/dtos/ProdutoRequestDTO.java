package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO de criação de produto")
public class ProdutoRequestDTO {

    @Schema(description = "Nome do produto", example = "Projetor Data Show")
    @Size(max = 99, message = "Nome deve ter até 100 caracteres")
    @NotBlank(message = "Nome não pode ser vazio")
    private String nome;

    @Schema(description = "Descrição", example = "Um console de Mini Projetor Wifi Portátil 5G Android")
    @Size(max = 199, message = "Descrição deve ter até 200 caracteres")
    private String descricao;

    @Schema(description = "O preço unitário do produto", example = "234.00")
    @DecimalMin(value = "0.0", message = "Preço deve ser >= 0")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "O preço deve ter até 2 casas decimais")
    @NotNull(message = "Preço não pode ser nulo")
    private BigDecimal preco;

    @Schema(description = "A quantidade disponível do produto", example = "16")
    @Min(value = 0, message = "Estoque deve ser >= 0")
    private Integer estoque;

    @Schema(description = "Os ids das categorias a qual esse produto pertence", example = "[1, 2]")
    @NotEmpty(message = "Deve existe pelo menos 1 categoria")
    private List<Long> categoriasIds;
}