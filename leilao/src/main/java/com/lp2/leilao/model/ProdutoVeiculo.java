package com.lp2.leilao.model;


import com.lp2.leilao.model.dto.*;
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
@Inheritance(strategy = InheritanceType.JOINED)
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
        this.tipoProduto = produtoVeiculo.tipoProduto != null ? produtoVeiculo.tipoProduto : produtoVeiculoEncontrado.getTipoProduto();
        this.marca = produtoVeiculo.marca != null ? produtoVeiculo.marca : produtoVeiculoEncontrado.getMarca();
        this.modelo = produtoVeiculo.modelo != null ? produtoVeiculo.modelo : produtoVeiculoEncontrado.getModelo();
        this.descricao = produtoVeiculo.descricao != null ? produtoVeiculo.descricao : produtoVeiculoEncontrado.getDescricao();
        this.anoFabricacao = produtoVeiculo.anoFabricacao != null ? produtoVeiculo.anoFabricacao : produtoVeiculoEncontrado.getAnoFabricacao();
        this.condicao = produtoVeiculo.condicao != null ? produtoVeiculo.condicao : produtoVeiculoEncontrado.getCondicao();
        this.numeroPlaca = produtoVeiculo.numeroPlaca != null ? produtoVeiculo.numeroPlaca : produtoVeiculoEncontrado.getNumeroPlaca();
        this.quilometragem = produtoVeiculo.quilometragem != null ? produtoVeiculo.quilometragem : produtoVeiculoEncontrado.getQuilometragem();
        this.motor = produtoVeiculo.motor != null ? produtoVeiculo.motor : produtoVeiculoEncontrado.getMotor();
        this.cor = produtoVeiculo.cor != null ? produtoVeiculo.cor : produtoVeiculoEncontrado.getCor();
        this.precoInicial = produtoVeiculo.precoInicial != null ? produtoVeiculo.precoInicial : produtoVeiculoEncontrado.getPrecoInicial();
        this.leilao = produtoVeiculo.leilao;
    }

    public ProdutoVeiculo(CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoVeiculoDTO.tipoProduto();
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public ProdutoVeiculo(CadastroProdutoVeiculoMotocicletaDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoVeiculoDTO.tipoProduto();
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public ProdutoVeiculo(CadastroProdutoVeiculoCarroDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoVeiculoDTO.tipoProduto();
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    public ProdutoVeiculo(CadastroProdutoVeiculoCaminhaoDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoVeiculoDTO.tipoProduto();
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;

    }

    public ProdutoVeiculo(CadastroProdutoVeiculoUtilitarioDTO cadastroProdutoVeiculoDTO, Leilao leilao) {
        this.tipoProduto = cadastroProdutoVeiculoDTO.tipoProduto();
        this.marca = cadastroProdutoVeiculoDTO.marca();
        this.modelo = cadastroProdutoVeiculoDTO.modelo();
        this.descricao = cadastroProdutoVeiculoDTO.descricao();
        this.anoFabricacao = cadastroProdutoVeiculoDTO.anoFabricacao();
        this.condicao = cadastroProdutoVeiculoDTO.condicao();
        this.numeroPlaca = cadastroProdutoVeiculoDTO.numeroPlaca();
        this.quilometragem = cadastroProdutoVeiculoDTO.quilometragem();
        this.motor = cadastroProdutoVeiculoDTO.motor();
        this.cor = cadastroProdutoVeiculoDTO.cor();
        this.precoInicial = cadastroProdutoVeiculoDTO.precoInicial();
        this.leilao = leilao;
    }

    @Override
    public String toString() {
        return "ProdutoVeiculo{" +
                "id=" + id +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", anoFabricacao='" + anoFabricacao + '\'' +
                ", condicao=" + condicao +
                ", numeroPlaca=" + numeroPlaca +
                ", quilometragem=" + quilometragem +
                ", motor=" + motor +
                ", cor='" + cor + '\'' +
                ", precoInicial=" + precoInicial +
                ", leilao=" + leilao +
                '}';
    }
}
