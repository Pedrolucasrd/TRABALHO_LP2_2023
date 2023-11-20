package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaMonitorDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaMonitorDTO;
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
public class Monitor extends ProdutoInformatica {
    private String tamanhoTela;



    public Monitor(CadastroProdutoInformaticaMonitorDTO cadastroProdutoInformaticaMonitorDTO, Leilao leilao, String tamanhoTela) {
        super(cadastroProdutoInformaticaMonitorDTO,leilao);
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public ExibicaoProdutoInformaticaMonitorDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaMonitorDTO(this);
    }
}


