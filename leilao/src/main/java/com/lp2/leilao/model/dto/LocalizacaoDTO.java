package com.lp2.leilao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LocalizacaoDTO(
        @Schema(defaultValue = "49092618")

        String cep,
        @Schema(defaultValue = "80")
        Long numero,
        @Schema(defaultValue = "Rua Oito")

        String endereco,
        @Schema(defaultValue = "Aracaju")

        String cidade,
        @Schema(defaultValue = "SE")

        String estado
) {
}
