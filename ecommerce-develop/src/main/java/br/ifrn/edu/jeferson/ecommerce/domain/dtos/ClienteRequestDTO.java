package br.ifrn.edu.jeferson.ecommerce.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "DTO para requisição de cliente")
public class ClienteRequestDTO {

    @Schema(description = "Nome do Cliente", example = "Maria")
    @NotBlank(message = "Obrigatório")
    private String nome;

    @Schema(example = "maria@gmail.com")
    @NotBlank(message = "Obrigatório")
    @Size(max = 99, message = "Email deve possuir até 100 caracteres")
    @Email(message = "Email deve ser válido")
    private String email;

    @Schema(example = "123.456.789-10")
    @NotBlank(message = "Obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "CPF deve possuir o formato XXX.XXX.XXX-XX")
    private String cpf;

    @Schema(example = "(00) 10000-1111")
    @NotBlank(message = "Obrigatório")
    @Pattern(regexp = "\\(\\d{2}\\) 9\\d{4}-\\d{4}", message = "Telefone deve possuir o formato (XX) XXXXX-XXXX")
    private String telefone;
}
