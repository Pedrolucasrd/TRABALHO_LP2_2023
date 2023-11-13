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
public class Notebook extends ProdutoInformatica {
    private String tamanhoTela;



    public Notebook(CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaNotebookDTO, Leilao leilao, String tamanhoTela) {
        super(cadastroProdutoInformaticaNotebookDTO,leilao);
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public ExibicaoProdutoInformaticaNotebookDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaNotebookDTO(this);
    }
}


