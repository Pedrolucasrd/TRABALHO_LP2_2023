package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Caminhao;
import com.lp2.leilao.model.Condicao;
import com.lp2.leilao.model.Utilitario;

public record CadastroProdutoVeiculoUtilitarioDTO(


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

        Integer capacidadePessoa
) {




}
