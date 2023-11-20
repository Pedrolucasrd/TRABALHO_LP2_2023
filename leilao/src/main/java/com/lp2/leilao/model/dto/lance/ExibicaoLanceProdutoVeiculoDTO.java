package com.lp2.leilao.model.dto.lance;

import com.lp2.leilao.model.LanceProdutoVeiculo;

import java.time.LocalDateTime;

public record ExibicaoLanceProdutoVeiculoDTO(
        Long id,
        Double valor,
        LocalDateTime data,
        Long idProduto,
        String cpfCliente
) {
    public ExibicaoLanceProdutoVeiculoDTO(LanceProdutoVeiculo lanceProdutoVeiculo) {
        this(lanceProdutoVeiculo.getId(),
                lanceProdutoVeiculo.getValor(),
                lanceProdutoVeiculo.getData(),
                lanceProdutoVeiculo.getProdutoVeiculo().getId(),
                lanceProdutoVeiculo.getCliente().getCpf());
    }
}
