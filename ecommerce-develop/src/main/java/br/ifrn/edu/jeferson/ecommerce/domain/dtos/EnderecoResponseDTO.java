package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta de Endereco")
public class EnderecoResponseDTO {
    @Schema(description = "ID do endereco", example = "1")
    private Long id;

    @Schema(description = "Nome da rua",example = "Rua Antônio")
    private String rua;

    @Schema(description = "Numero",example = "87")
    private String numero;

    @Schema(description = "Bairro",example = "Centro")
    private String bairro;

    @Schema(description = "Cidade",example = "Campina Grande")
    private String cidade;

    @Schema(description = "Estado",example = "Paraiba")
    private String estado;

    @Schema(description = "CEP",example = "10000-000")
    private String cep;
}
