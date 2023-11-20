package com.lp2.leilao.model.dto.produtoInformatica;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record CadastroProdutoInformaticaDTO(

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
