package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.Condicao;

public record CadastroProdutoInformaticaHubDTO(
        String tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroSerie,
        String cor,
        Double PrecoInicial,
        Integer quantidadePortas
) {
}
