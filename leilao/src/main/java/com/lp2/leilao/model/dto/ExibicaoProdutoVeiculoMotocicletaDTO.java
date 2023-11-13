package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.Motocicleta;
import com.lp2.leilao.model.enums.TipoProdutoVeiculo;

public record ExibicaoProdutoVeiculoMotocicletaDTO(
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
        Integer cilidradas,
        Long leilaoId
) {


    public ExibicaoProdutoVeiculoMotocicletaDTO(Motocicleta produtoVeiculo) {
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
                produtoVeiculo.getCilindradas(),
                produtoVeiculo.getLeilao().getId());
    }

}
