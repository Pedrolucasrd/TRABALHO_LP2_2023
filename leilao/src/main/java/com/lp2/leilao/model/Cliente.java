package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.cliente.AtualizaClienteDTO;
import com.lp2.leilao.model.dto.cliente.CadastroClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    private String cpf;

    private String nome;

    private String email;

    private String telefone;

    private String senha;

    public Cliente(CadastroClienteDTO cadastroClienteDTO) {
        this.cpf = cadastroClienteDTO.cpf();
        this.nome = cadastroClienteDTO.nome();
        this.email = cadastroClienteDTO.email();
        this.telefone = cadastroClienteDTO.telefone();
        this.senha = cadastroClienteDTO.senha();
    }

    public Cliente(Cliente cliente, AtualizaClienteDTO atualizaClienteDTO) {
        this.cpf = cliente.cpf;
        this.nome = atualizaClienteDTO.nome() != null ? atualizaClienteDTO.nome() : cliente.getNome();
        this.email = atualizaClienteDTO.email() != null ? atualizaClienteDTO.email() : cliente.email;
        this.telefone = atualizaClienteDTO.telefone() != null ? atualizaClienteDTO.telefone() : cliente.getTelefone();
        this.senha = atualizaClienteDTO.senha() != null ? atualizaClienteDTO.senha() : cliente.getSenha();
    }

}
