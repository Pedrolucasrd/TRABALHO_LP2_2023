package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Condicao;
import com.lp2.leilao.model.ProdutoVeiculo;

public record CadastroProdutoVeiculoCaminhaoDTO(

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

        Integer capacidadeCarga


) {

}
