package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.CadastroProdutoInformaticaHubDTO;
import com.lp2.leilao.model.dto.CadastroProdutoInformaticaSwitchDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoInformaticaHubDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoInformaticaSwitchDTO;
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
public class Switch extends ProdutoInformatica {
    private Integer quantidadePortas;

    public Switch(CadastroProdutoInformaticaSwitchDTO cadastroProdutoInformaticaSwitchDTO, Leilao leilao, Integer quantidadePortas) {
        super(cadastroProdutoInformaticaSwitchDTO,leilao);
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public ExibicaoProdutoInformaticaSwitchDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaSwitchDTO(this);
    }
}


