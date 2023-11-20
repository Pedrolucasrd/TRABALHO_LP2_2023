package com.lp2.leilao.model.dto.cliente;

import io.swagger.v3.oas.annotations.media.Schema;

public record AtualizaClienteDTO(
        @Schema(defaultValue = "Antonio Carlos")
        String nome,
        @Schema(defaultValue = "antonio@gmail.com")
        String email,
        @Schema(defaultValue = "1835631875")
        String telefone,
        @Schema(defaultValue = "NovaSenha@forte123")
        String senha
) {
}
