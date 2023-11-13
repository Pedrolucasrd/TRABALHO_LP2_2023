package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.Monitor;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record ExibicaoProdutoInformaticaMonitorDTO(
        Long id,
        TipoProdutoInformatica tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroSerie,
        String cor,
        Double PrecoInicial,
        String tamanhoTela,
        Long leilaoId
) {
    public ExibicaoProdutoInformaticaMonitorDTO(Monitor produtoInformatica) {
        this(produtoInformatica.getId(),
                produtoInformatica.getTipoProduto(),
                produtoInformatica.getMarca(),
                produtoInformatica.getModelo(),
                produtoInformatica.getDescricao(),
                produtoInformatica.getAnoFabricacao(),
                produtoInformatica.getCondicao(),
                produtoInformatica.getNumeroSerie(),
                produtoInformatica.getCor(),
                produtoInformatica.getPrecoInicial(),
                produtoInformatica.getTamanhoTela(),
                produtoInformatica.getLeilao().getId());
    }



}
