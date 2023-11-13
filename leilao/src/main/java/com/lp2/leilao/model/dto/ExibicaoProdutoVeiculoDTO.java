package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.model.enums.TipoProdutoVeiculo;

public record ExibicaoProdutoVeiculoDTO(
        Long id,
        TipoProdutoVeiculo tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroPlaca,
        Double quilometragem,
        Double motor,
        String cor,
        Double precoInicial,
        Long leilaoId
) {


    public ExibicaoProdutoVeiculoDTO(ProdutoVeiculo produtoVeiculo) {
        this(produtoVeiculo.getId(),
                produtoVeiculo.getTipoProduto(),
                produtoVeiculo.getMarca(),
                produtoVeiculo.getModelo(),
                produtoVeiculo.getDescricao(),
                produtoVeiculo.getAnoFabricacao(),
                produtoVeiculo.getCondicao(),
                produtoVeiculo.getNumeroPlaca(),
                produtoVeiculo.getQuilometragem(),
                produtoVeiculo.getMotor(),
                produtoVeiculo.getCor(),
                produtoVeiculo.getPrecoInicial(),
                produtoVeiculo.getLeilao().getId());
    }

}
