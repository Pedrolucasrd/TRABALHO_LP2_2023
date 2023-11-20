package com.lp2.leilao.model.dto.produtoInformatica;

import com.lp2.leilao.model.enums.Condicao;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroProdutoInformaticaNotebookDTO(
        TipoProdutoInformatica tipoProduto,

        @Schema(defaultValue = "ACER")
        String marca,
        @Schema(defaultValue = "Modelo Teste 123")
        String modelo,
        @Schema(defaultValue = "Portátil, potente, confiável, versátil, acessível.")
        String descricao,

        @Schema(defaultValue = "2015")
        String anoFabricacao,
        Condicao condicao,

        @Schema(defaultValue = "111145521")
        Integer numeroSerie,

        @Schema(defaultValue = "Branco")
        String cor,

        @Schema(defaultValue = "1000")
        Double PrecoInicial,
        @Schema(defaultValue = "1350x1100")
        String tamanhoTela
) {
}
