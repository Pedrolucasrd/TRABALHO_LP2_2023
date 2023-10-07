package com.lp2.leilao.model;


import com.lp2.leilao.model.dto.CadastroProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.CadastroProdutoVeiculoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto_informatica")
public class ProdutoInformatica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProduto;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Condicao condicao;

    private Integer numeroSerie;

    private String cor;

    private Double precoInicial;


    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;

    public ProdutoInformatica(ProdutoInformatica produtoInformaticaEncontrado, ProdutoInformatica produtoInformatica){
        this.id = produtoInformaticaEncontrado.getId();

        this.tipoProduto = produtoInformatica.tipoProduto != null ? produtoInformatica.tipoProduto : produtoInformaticaEncontrado.getTipoProduto();
        this.marca = produtoInformatica.marca != null ? produtoInformatica.marca : produtoInformaticaEncontrado.getMarca();
        this.modelo = produtoInformatica.modelo != null ? produtoInformatica.modelo : produtoInformaticaEncontrado.getModelo();
        this.descricao = produtoInformatica.descricao != null ? produtoInformatica.descricao : produtoInformaticaEncontrado.getDescricao() ;
        this.anoFabricacao = produtoInformatica.anoFabricacao != null ? produtoInformatica.anoFabricacao : produtoInformaticaEncontrado.getAnoFabricacao();
        this.condicao = produtoInformatica.condicao != null ? produtoInformatica.condicao : produtoInformaticaEncontrado.getCondicao();
        this.numeroSerie = produtoInformatica.numeroSerie != null ? produtoInformatica.numeroSerie : produtoInformaticaEncontrado.getNumeroSerie();
        this.cor = produtoInformatica.cor != null ? produtoInformatica.cor : produtoInformaticaEncontrado.getCor();
        this.precoInicial = produtoInformatica.precoInicial != null ? produtoInformatica.precoInicial : produtoInformaticaEncontrado.getPrecoInicial();
        this.leilao = produtoInformatica.leilao;
    }

    public ProdutoInformatica(CadastroProdutoInformaticaDTO cadastroProdutoInformaticaDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoInformaticaDTO.tipoProduto();
        this.marca = cadastroProdutoInformaticaDTO.marca();
        this.modelo = cadastroProdutoInformaticaDTO.modelo();
        this.descricao = cadastroProdutoInformaticaDTO.descricao();
        this.anoFabricacao = cadastroProdutoInformaticaDTO.anoFabricacao();
        this.condicao = cadastroProdutoInformaticaDTO.condicao();
        this.numeroSerie = cadastroProdutoInformaticaDTO.numeroSerie();
        this.cor = cadastroProdutoInformaticaDTO.cor();
        this.precoInicial = cadastroProdutoInformaticaDTO.PrecoInicial();
        this.leilao = leilao;
    }

}
