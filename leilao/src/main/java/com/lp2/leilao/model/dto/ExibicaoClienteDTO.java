package com.lp2.leilao.model.dto;

import com.lp2.leilao.model.Cliente;

import java.util.Optional;

public record ExibicaoClienteDTO(
        String cpf,
        String nome,
        String email,
        String telefone,
        String senha
) {
    public ExibicaoClienteDTO(Cliente cliente) {
        this(cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getSenha());
    }
}
