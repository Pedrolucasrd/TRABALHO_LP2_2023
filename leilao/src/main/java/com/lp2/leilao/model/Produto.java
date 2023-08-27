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
@Table(name = "produto")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProduto;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Condicao condicao;

    public Produto(Produto produtoEncontrado, Produto produto){
        this.id = produtoEncontrado.getId();
        this.tipoProduto = produto.tipoProduto;
        this.marca = produto.marca;
        this.modelo = produto.modelo;
        this.descricao = produto.descricao;
        this.anoFabricacao = produto.anoFabricacao;
        this.condicao = produto.condicao;
    }

}
