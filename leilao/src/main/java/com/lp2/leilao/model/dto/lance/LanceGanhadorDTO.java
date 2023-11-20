package com.lp2.leilao.model.dto.lance;

import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.LanceProdutoVeiculo;
import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.util.FormatadorData;

import java.time.LocalDateTime;

public record LanceGanhadorDTO(
        Long id,
        Double valor,
        String data
) {
    public LanceGanhadorDTO(LanceProdutoInformatica lanceProdutoInformatica) {
        this(lanceProdutoInformatica.getId(),
                lanceProdutoInformatica.getValor(),
                FormatadorData.formatarData(lanceProdutoInformatica.getData()));

    }
    public LanceGanhadorDTO(LanceProdutoVeiculo lanceProdutoVeiculo) {
        this(lanceProdutoVeiculo.getId(),
                lanceProdutoVeiculo.getValor(),
                FormatadorData.formatarData(lanceProdutoVeiculo.getData()));
    }
}
