package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Condicao;
import com.lp2.leilao.model.ProdutoInformatica;

public record ExibicaoProdutoInformaticaDTO(
        Long id,
        String tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroSerie,
        String cor,
        Double PrecoInicial,
        Long leilaoId
) {
    public ExibicaoProdutoInformaticaDTO(ProdutoInformatica produtoInformatica) {
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
                produtoInformatica.getLeilao().getId());
    }



}
