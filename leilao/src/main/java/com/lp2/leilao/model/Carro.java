package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.*;
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
public class Carro extends ProdutoVeiculo {
    private Integer quantidadePortas;

    public Carro(CadastroProdutoVeiculoCarroDTO cadastroProdutoVeiculoCarroDTO, Leilao leilao,Integer quantidadePortas) {
        super(cadastroProdutoVeiculoCarroDTO,leilao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public ExibicaoProdutoVeiculoCarroDTO criacaoDTO() {
        return new ExibicaoProdutoVeiculoCarroDTO(this);
    }
}


