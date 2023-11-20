package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.produtoInformatica.CadastroProdutoInformaticaNotebookDTO;
import com.lp2.leilao.model.dto.produtoInformatica.ExibicaoProdutoInformaticaNotebookDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

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

    public Notebook(CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaDTO, ProdutoInformatica produtoEncontrado, ProdutoInformatica produtoInformatica1) {
        super(produtoEncontrado,
                new ProdutoInformatica(cadastroProdutoInformaticaDTO, produtoEncontrado.getLeilao()));
        this.tamanhoTela = cadastroProdutoInformaticaDTO.tamanhoTela();
    }




    @Override
    public ExibicaoProdutoInformaticaNotebookDTO criacaoDTO() {
        return new ExibicaoProdutoInformaticaNotebookDTO(this);
    }


}


