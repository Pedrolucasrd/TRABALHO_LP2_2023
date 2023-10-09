package com.lp2.leilao.model.dto;

public record CadastroClienteDTO(
        String cpf,
        String nome,
        String email,
        String telefone,
        String senha
) {
}
