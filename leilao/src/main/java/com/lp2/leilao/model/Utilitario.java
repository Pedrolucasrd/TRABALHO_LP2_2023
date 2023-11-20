package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoVeiculo.CadastroProdutoVeiculoUtilitarioDTO;
import com.lp2.leilao.model.dto.produtoVeiculo.ExibicaoProdutoVeiculoUtilitarioDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilitario extends ProdutoVeiculo {
    private Integer capacidadePessoas;

    public Utilitario(CadastroProdutoVeiculoUtilitarioDTO cadastroProdutoVeiculoUtilitarioDTO, Leilao leilao, Integer capacidadePessoas) {
        super(cadastroProdutoVeiculoUtilitarioDTO,leilao);
        this.capacidadePessoas = capacidadePessoas;
    }

    @Override
    public ExibicaoProdutoVeiculoUtilitarioDTO criacaoDTO() {
        return new ExibicaoProdutoVeiculoUtilitarioDTO(this);
    }
}


