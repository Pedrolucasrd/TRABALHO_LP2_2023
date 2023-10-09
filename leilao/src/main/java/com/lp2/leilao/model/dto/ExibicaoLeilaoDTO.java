package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.StatusLeilao;

import java.time.LocalDateTime;

public record ExibicaoLeilaoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataAbertura,
        LocalDateTime dataInicio,
        LocalDateTime dataFechamento,
        StatusLeilao status
) {
    public ExibicaoLeilaoDTO(Leilao leilao) {
        this(leilao.getId(),
                leilao.getNome(),
                leilao.getDescricao(),
                leilao.getDataAbertura(),
                leilao.getDataInicio(),
                leilao.getDataFechamento(),
                leilao.getStatus());
    }
}
