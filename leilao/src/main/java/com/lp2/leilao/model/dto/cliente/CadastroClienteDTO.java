package com.lp2.leilao.model.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroClienteDTO(
        @Schema(defaultValue = "88580310083")
        String cpf,
        @Schema(defaultValue = "Antonio Carlos")
        String nome,
        @Schema(defaultValue = "antonio@gmail.com")
        String email,
        @Schema(defaultValue = "1835631875")
        String telefone,
        @Schema(defaultValue = "Senha@forte123")
        String senha
) {
}
