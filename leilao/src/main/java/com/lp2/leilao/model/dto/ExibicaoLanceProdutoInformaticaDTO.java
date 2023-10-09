package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.LanceProdutoInformatica;

import java.time.LocalDateTime;

public record ExibicaoLanceProdutoInformaticaDTO(
        Long id,
        Double valor,
        LocalDateTime data,
        Long idProduto,
        String cpfCliente
) {
    public ExibicaoLanceProdutoInformaticaDTO(LanceProdutoInformatica lanceProdutoInformatica) {
        this(lanceProdutoInformatica.getId(),
                lanceProdutoInformatica.getValor(),
                lanceProdutoInformatica.getData(),
                lanceProdutoInformatica.getProdutoInformatica().getId(),
                lanceProdutoInformatica.getCliente().getCpf());
    }
}
