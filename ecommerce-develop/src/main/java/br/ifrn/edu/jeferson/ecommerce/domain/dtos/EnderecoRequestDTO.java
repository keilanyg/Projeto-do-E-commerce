package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para requisição de endereco")
public class EnderecoRequestDTO {

    @Schema(description = "Nome da rua", example = "Rua Antônio")
    @NotBlank(message = "Obrigatório")
    private String rua;

    @Schema(description = "Número da casa", example = "87")
    @NotBlank(message = "Obrigatório")
    private String numero;

    @Schema(description = "Nome do bairro", example = "Centro")
    @NotBlank(message = "Obrigatório")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "Campina Grande")
    @NotBlank(message = "Obrigatório")
    private String cidade;

    @Schema(description = "Nome do estado", example = "Paraiba")
    @NotBlank(message = "Obrigatório")
    private String estado;

    @Schema(description = "CEP", example = "10000-000")
    @NotBlank(message = "Obrigatório")
    private String cep;
}
