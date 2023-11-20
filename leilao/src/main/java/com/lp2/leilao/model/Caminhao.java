package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoVeiculo.CadastroProdutoVeiculoCaminhaoDTO;
import com.lp2.leilao.model.dto.produtoVeiculo.ExibicaoProdutoVeiculoCaminhaoDTO;
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
public class Caminhao  extends ProdutoVeiculo {
    private Integer  capacidadeCarga;

    public Caminhao(CadastroProdutoVeiculoCaminhaoDTO cadastroProdutoVeiculoCaminhaoDTO, Leilao leilao, Integer capacidadeCarga){
        super(cadastroProdutoVeiculoCaminhaoDTO,leilao);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public ExibicaoProdutoVeiculoCaminhaoDTO criacaoDTO() {
        return new ExibicaoProdutoVeiculoCaminhaoDTO(this);
    }
}



