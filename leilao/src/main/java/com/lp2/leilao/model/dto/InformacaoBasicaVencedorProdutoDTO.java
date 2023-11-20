package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.model.dto.leilao.GanhadorLeilaoDTO;

public record InformacaoBasicaVencedorProdutoDTO(
        Long produtoId,
        String tipoProduto,
        String descricao,

        GanhadorLeilaoDTO ganhador

) {


    public InformacaoBasicaVencedorProdutoDTO(ProdutoInformatica produtoInformatica, GanhadorLeilaoDTO ganhador) {
        this(produtoInformatica.getId(),
                produtoInformatica.getTipoProduto().toString(),
                produtoInformatica.getDescricao(),
                ganhador);
    }

    public InformacaoBasicaVencedorProdutoDTO(ProdutoVeiculo produtoVeiculo,GanhadorLeilaoDTO ganhador) {
        this(produtoVeiculo.getId(),
                produtoVeiculo.getTipoProduto().toString(),
                produtoVeiculo.getDescricao(),
                ganhador);
    }
}
