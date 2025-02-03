package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para requisição de endereço")
public class EnderecoRequestDTO {

    @Schema(description = "Nome da rua", example = "Rua Antônio")
    @NotBlank(message = "O campo rua é obrigatório")
    private String rua;

    @Schema(description = "Número da casa", example = "87")
    @NotBlank(message = "O campo número é obrigatório")
    private String numero;

    @Schema(description = "Nome do bairro", example = "Centro")
    @NotBlank(message = "O campo bairro é obrigatório")
    private String bairro;

    @Schema(description = "Nome da cidade", example = "Campina Grande")
    @NotBlank(message = "O campo cidade é obrigatório")
    private String cidade;

    @Schema(description = "Nome do estado", example = "Paraíba") // Corrigido para acentuar "Paraíba"
    @NotBlank(message = "O campo estado é obrigatório")
    private String estado;

    @Schema(description = "CEP", example = "10000-000")
    @NotBlank(message = "O campo CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve ter o formato XXXXX-XXX")
    private String cep;
}
