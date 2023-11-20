package com.lp2.leilao.model.dto.produtoInformatica;

import com.lp2.leilao.model.enums.Condicao;
import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroProdutoInformaticaRoteadorDTO(
        @Schema(defaultValue = "TP-Link", description = "Marca do roteador") String marca,
        @Schema(defaultValue = "Modelo R1234", description = "Modelo do roteador") String modelo,
        @Schema(defaultValue = "Roteador sem fio de alta velocidade", description = "Descrição do roteador") String descricao,
        @Schema(defaultValue = "2023", description = "Ano de fabricação do roteador") String anoFabricacao,
        @Schema(description = "Condição do roteador") Condicao condicao,
        @Schema(defaultValue = "9876543210", description = "Número de série do roteador") Integer numeroSerie,
        @Schema(defaultValue = "Preto", description = "Cor do roteador") String cor,
        @Schema(defaultValue = "149.99", description = "Preço inicial do roteador") Double precoInicial,
        @Schema(defaultValue = "4", description = "Quantidade de portas do roteador") Integer quantidadePortas
) {
}
