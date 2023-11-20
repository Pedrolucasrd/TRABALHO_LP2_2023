package com.lp2.leilao.model.dto.produtoInformatica;

import com.lp2.leilao.model.enums.Condicao;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroProdutoInformaticaSwitchDTO(
        @Schema(defaultValue = "MarcaX", description = "Marca do switch de rede") String marca,
        @Schema(defaultValue = "Modelo Rede 2000", description = "Modelo do switch de rede") String modelo,
        @Schema(defaultValue = "Switch para conexão de cabos de internet", description = "Descrição do switch de rede") String descricao,
        @Schema(defaultValue = "2022", description = "Ano de fabricação do switch de rede") String anoFabricacao,
        @Schema(description = "Condição do switch de rede") Condicao condicao,
        @Schema(defaultValue = "987654321", description = "Número de série do switch de rede") Integer numeroSerie,
        @Schema(defaultValue = "Preto", description = "Cor do switch de rede") String cor,
        @Schema(defaultValue = "99.99", description = "Preço inicial do switch de rede") Double precoInicial,
        @Schema(defaultValue = "8", description = "Quantidade de portas do switch de rede") Integer quantidadePortas
) {
}
