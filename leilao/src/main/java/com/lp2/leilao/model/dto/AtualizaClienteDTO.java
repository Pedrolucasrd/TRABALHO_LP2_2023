package com.lp2.leilao.model.dto;

public record AtualizaClienteDTO(
        String nome,
        String email,
        String telefone,
        String senha
) {
}
