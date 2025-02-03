package br.ifrn.edu.jeferson.ecommerce.controller;

import br.ifrn.edu.jeferson.ecommerce.domain.dtos.EnderecoRequestDTO;
import br.ifrn.edu.jeferson.ecommerce.domain.dtos.EnderecoResponseDTO;
import br.ifrn.edu.jeferson.ecommerce.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
@RequestMapping("/api/enderecos")
@Tag(name = "Enderecos", description = "API de gerenciamento de endereços dos Produtos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    // Injeção via construtor
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @Operation(summary = "Criar um novo endereço")
    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> salvar(@RequestBody EnderecoRequestDTO enderecoDto) {
        return ResponseEntity.ok(enderecoService.salvar(enderecoDto));
    }

    @Operation(summary = "Listar todos os endereços")
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<EnderecoResponseDTO>> listar() {
        return ResponseEntity.ok(enderecoService.lista());
    }

    @Operation(summary = "Deletar um endereço")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualizar um endereço")
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizar(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoDto) {
        return ResponseEntity.ok(enderecoService.atualizar(id, enderecoDto));
    }
}
