package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.enums.StatusLeilao;

import java.time.LocalDateTime;

public record ExibicaoLeilaoCriadoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataAbertura,
        StatusLeilao status
) {
    public ExibicaoLeilaoCriadoDTO(Leilao leilao) {
        this(leilao.getId(),
                leilao.getNome(),
                leilao.getDescricao(),
                leilao.getDataAbertura(),
                leilao.getStatus());
    }
}
