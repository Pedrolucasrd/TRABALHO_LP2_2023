package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoVeiculo.CadastroProdutoVeiculoMotocicletaDTO;
import com.lp2.leilao.model.dto.produtoVeiculo.ExibicaoProdutoVeiculoMotocicletaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Motocicleta extends ProdutoVeiculo {
    private Integer cilindradas;



    public Motocicleta(CadastroProdutoVeiculoMotocicletaDTO cadastroProdutoVeiculoDTO, Leilao leilao, Integer cilindradas) {
        super(cadastroProdutoVeiculoDTO,leilao);
        this.cilindradas = cilindradas;
    }

    @Override
    public ExibicaoProdutoVeiculoMotocicletaDTO criacaoDTO() {
        return new ExibicaoProdutoVeiculoMotocicletaDTO(this);
    }
}


