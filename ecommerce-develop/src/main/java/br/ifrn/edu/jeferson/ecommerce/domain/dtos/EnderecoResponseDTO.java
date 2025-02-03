package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta de Endereço")
public class EnderecoResponseDTO {

    @Schema(description = "ID do endereço", example = "1") // Corrigido "endereco" para "endereço"
    private Long id;

    @Schema(description = "Nome da rua", example = "Rua Antônio")
    private String rua;

    @Schema(description = "Número", example = "87")
    private String numero;

    @Schema(description = "Bairro", example = "Centro")
    private String bairro;

    @Schema(description = "Cidade", example = "Campina Grande")
    private String cidade;

    @Schema(description = "Estado", example = "Paraíba") // Corrigido para acentuar "Paraíba"
    private String estado;

    @Schema(description = "CEP", example = "10000-000")
    private String cep;
}
