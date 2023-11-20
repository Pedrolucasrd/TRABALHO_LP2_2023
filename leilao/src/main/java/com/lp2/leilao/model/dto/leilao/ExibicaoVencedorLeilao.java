package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.dto.cliente.ExibicaoClienteDTO;
import com.lp2.leilao.model.enums.TipoProdutoInformatica;

public record ExibicaoVencedorLeilao(
        Long id,
        TipoProdutoInformatica tipoProduto,

        ExibicaoClienteDTO vencedor


) {


    public ExibicaoVencedorLeilao(LanceProdutoInformatica lanceGanhador) {
        this(lanceGanhador.getProdutoInformatica().getId(),
                lanceGanhador.getProdutoInformatica().getTipoProduto(),
                new ExibicaoClienteDTO(lanceGanhador.getCliente()));
    }
}
