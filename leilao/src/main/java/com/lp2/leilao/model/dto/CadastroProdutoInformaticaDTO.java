package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Condicao;

public record CadastroProdutoInformaticaDTO(
        String tipoProduto,
        String marca,
        String modelo,
        String descricao,
        String anoFabricacao,
        Condicao condicao,
        Integer numeroSerie,
        String cor,
        Double PrecoInicial
) {
}
