package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.enums.StatusLeilao;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhamentoLeilaoDTO(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataAbertura,
        LocalDateTime dataInicio,
        LocalDateTime dataFechamento,
        List<InformacaoBasicaProdutoDTO> produtos,
        List<ExibicaoInstituicaoFinanceiraDTO> instituicoesFinanceira,
        StatusLeilao status
) {
    public DetalhamentoLeilaoDTO(Leilao leilao, List<InformacaoBasicaProdutoDTO> produtos,List<ExibicaoInstituicaoFinanceiraDTO> instituicoesFinanceira) {
        this(leilao.getId(),
                leilao.getNome(),
                leilao.getDescricao(),
                leilao.getDataAbertura(),
                leilao.getDataInicio(),
                leilao.getDataFechamento(),
                produtos,
                instituicoesFinanceira,
                leilao.getStatus());
    }
}
