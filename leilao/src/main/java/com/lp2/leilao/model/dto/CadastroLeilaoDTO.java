package com.lp2.leilao.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record CadastroLeilaoDTO(
        String nome,

        @Schema(defaultValue = "Leilão teste!")

        String descricao,

        @Schema(defaultValue = "25/12/2023 14:30:00")
        String dataInicio,
        @Schema(defaultValue = "01/01/2024 14:30:00")

        String dataFechamento
        ) {
}
