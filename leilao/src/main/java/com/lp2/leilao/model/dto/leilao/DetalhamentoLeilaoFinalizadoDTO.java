package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.InformacaoBasicaVencedorProdutoDTO;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.util.ConfenciaStatusLeilao;
import com.lp2.leilao.util.FormatadorData;

import java.util.List;

public record DetalhamentoLeilaoFinalizadoDTO(
        Long id,
        String nome,
        String descricao,
        String dataAbertura,
        String dataInicio,
        String dataFechamento,
        List<InformacaoBasicaVencedorProdutoDTO> produtos,
        List<ExibicaoInstituicaoFinanceiraDTO> instituicoesFinanceira,
        StatusLeilao status
) {
    public DetalhamentoLeilaoFinalizadoDTO(Leilao leilao, List<InformacaoBasicaVencedorProdutoDTO> produtos, List<ExibicaoInstituicaoFinanceiraDTO> instituicoesFinanceira) {
        this(leilao.getId(),
                leilao.getNome(),
                leilao.getDescricao(),
                FormatadorData.formatarData(leilao.getDataAbertura()),
                FormatadorData.formatarData(leilao.getDataInicio()),
                FormatadorData.formatarData(leilao.getDataFechamento()),
                produtos,
                instituicoesFinanceira,
                ConfenciaStatusLeilao.conferirStatus(leilao));
    }
}
