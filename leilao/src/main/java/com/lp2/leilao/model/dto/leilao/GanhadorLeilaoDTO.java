package com.lp2.leilao.model.dto.leilao;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.dto.lance.LanceGanhadorDTO;

public record GanhadorLeilaoDTO(
        String cpf,
        String nome,
        String email,
        String telefone,

        LanceGanhadorDTO lance
) {
    public GanhadorLeilaoDTO(Cliente cliente,LanceGanhadorDTO lance) {
        this(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                lance);
    }
}