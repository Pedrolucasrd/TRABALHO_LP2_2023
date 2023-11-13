package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.LanceProdutoVeiculo;

import java.time.LocalDateTime;

public record ExibicaoLanceProdutoDTO(
        Long id,
        Double valor,
        LocalDateTime data,
        Long idProduto,
        String cpfCliente,
        CategoriaProduto categoriaProduto
) {
    public ExibicaoLanceProdutoDTO(LanceProdutoInformatica lanceProdutoInformatica) {
        this(lanceProdutoInformatica.getId(),
                lanceProdutoInformatica.getValor(),
                lanceProdutoInformatica.getData(),
                lanceProdutoInformatica.getProdutoInformatica().getId(),
                lanceProdutoInformatica.getCliente().getCpf(),
                CategoriaProduto.INFORMATICA);

    }
    public ExibicaoLanceProdutoDTO(LanceProdutoVeiculo lanceProdutoVeiculo) {
        this(lanceProdutoVeiculo.getId(),
                lanceProdutoVeiculo.getValor(),
                lanceProdutoVeiculo.getData(),
                lanceProdutoVeiculo.getProdutoVeiculo().getId(),
                lanceProdutoVeiculo.getCliente().getCpf(),
                CategoriaProduto.VEICULO);
    }
}
