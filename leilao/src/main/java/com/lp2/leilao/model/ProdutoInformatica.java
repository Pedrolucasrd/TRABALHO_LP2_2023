package com.lp2.leilao.model;


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
        this.tipoProduto = produtoInformatica.tipoProduto;
        this.marca = produtoInformatica.marca;
        this.modelo = produtoInformatica.modelo;
        this.descricao = produtoInformatica.descricao;
        this.anoFabricacao = produtoInformatica.anoFabricacao;
        this.condicao = produtoInformatica.condicao;
        this.numeroSerie = produtoInformatica.numeroSerie;
        this.cor = produtoInformatica.cor;
        this.precoInicial = produtoInformatica.precoInicial;
        this.leilao = produtoInformatica.leilao;

    }

}
