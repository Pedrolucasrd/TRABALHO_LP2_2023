package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.Condicao;

public record CadastroProdutoVeiculoMotocicletaDTO(
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
        Integer cilindradas
) {
}
