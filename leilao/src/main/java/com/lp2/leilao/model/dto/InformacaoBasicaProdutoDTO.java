package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;

public record InformacaoBasicaProdutoDTO(
        Long produtoId,
        String tipoProduto,
        String descricao
) {


    public InformacaoBasicaProdutoDTO(ProdutoInformatica produtoInformatica) {
        this(produtoInformatica.getId(),
                produtoInformatica.getTipoProduto().toString(),
                produtoInformatica.getDescricao());
    }

    public InformacaoBasicaProdutoDTO(ProdutoVeiculo produtoVeiculo) {
        this(produtoVeiculo.getId(),
                produtoVeiculo.getTipoProduto().toString(),
                produtoVeiculo.getDescricao());
    }
}
