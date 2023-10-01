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
@Table(name = "produto_veiculo")
public class ProdutoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProduto;

    private String marca;

    private String modelo;

    private String descricao;

    private String anoFabricacao;

    private Condicao condicao;

    private Integer numeroPlaca;

    private Double quilometragem;

    private Double motor;

    private String cor;

    private Double precoInicial;

    @ManyToOne
    @JoinColumn(name = "leilao_id")
    private Leilao leilao;
    public ProdutoVeiculo(ProdutoVeiculo produtoVeiculoEncontrado, ProdutoVeiculo produtoVeiculo) {
        this.id = produtoVeiculoEncontrado.getId();
        this.tipoProduto = produtoVeiculo.tipoProduto;
        this.marca = produtoVeiculo.marca;
        this.modelo = produtoVeiculo.modelo;
        this.descricao = produtoVeiculo.descricao;
        this.anoFabricacao = produtoVeiculo.anoFabricacao;
        this.condicao = produtoVeiculo.condicao;
        this.numeroPlaca = produtoVeiculo.numeroPlaca;
        this.quilometragem = produtoVeiculo.quilometragem;
        this.motor = produtoVeiculo.motor;
        this.cor = produtoVeiculo.cor;
        this.precoInicial = produtoVeiculo.precoInicial;
        this.leilao = produtoVeiculo.leilao;
    }
}
