package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaRoteadorDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaRoteadorDTO;
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
public class Roteador extends ProdutoInformatica {
    private Integer quantidadePortas;

    public Roteador(CadastroProdutoInformaticaRoteadorDTO cadastroProdutoInformaticaRoteadorDTO, Leilao leilao, Integer quantidadePortas) {
        super(cadastroProdutoInformaticaRoteadorDTO,leilao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public ExibicaoProdutoInformaticaRoteadorDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaRoteadorDTO(this);
    }
}


