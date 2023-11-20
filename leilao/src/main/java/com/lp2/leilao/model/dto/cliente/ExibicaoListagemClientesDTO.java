package com.lp2.leilao.model.dto.cliente;

import com.lp2.leilao.model.Cliente;

public record ExibicaoListagemClientesDTO(
        String cpf,
        String nome,
        String email,
        String telefone
) {
    public ExibicaoListagemClientesDTO(Cliente cliente) {
        this(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone());
    }
}
