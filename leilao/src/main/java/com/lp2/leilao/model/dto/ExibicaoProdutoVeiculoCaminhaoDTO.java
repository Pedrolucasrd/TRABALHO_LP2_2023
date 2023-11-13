package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Caminhao;
import com.lp2.leilao.model.enums.Condicao;

public record ExibicaoProdutoVeiculoCaminhaoDTO(

        Long id,
        String tipoProduto,
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
        Integer capacidadeCarga,
        Long leilaoId

) {
    public ExibicaoProdutoVeiculoCaminhaoDTO(Caminhao produtoVeiculo) {
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
                produtoVeiculo.getCapacidadeCarga(),
                produtoVeiculo.getLeilao().getId());
    }
}
