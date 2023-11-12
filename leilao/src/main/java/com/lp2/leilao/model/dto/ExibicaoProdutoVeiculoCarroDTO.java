package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Carro;
import com.lp2.leilao.model.Condicao;
import com.lp2.leilao.model.Motocicleta;

public record ExibicaoProdutoVeiculoCarroDTO(
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
        Integer quantidadePortas,
        Long leilaoId
) {


    public ExibicaoProdutoVeiculoCarroDTO(Carro produtoVeiculo) {
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
                produtoVeiculo.getQuantidadePortas(),
                produtoVeiculo.getLeilao().getId());
    }

}
