package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para resposta de cliente")
public class ClienteaResponseDTO {
    @Schema(description = "ID do Cliente", example = "1")
    private Long id;

    @Schema(description = "Nome do Cliente", example = "Maria")
    private String nome;

    @Schema(description = "email", example = "maria@gmail.com")
    private String email; 
    
    @Schema(description = "Número do CPF", example = "123.456.789-10")
    private String cpf;

    @Schema(example = "(00) 10000-1111")
    private String telefone;
}
