package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.CadastroProdutoVeiculoDTO;
import com.lp2.leilao.model.dto.CadastroProdutoVeiculoMotocicletaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.Optional;

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
}


