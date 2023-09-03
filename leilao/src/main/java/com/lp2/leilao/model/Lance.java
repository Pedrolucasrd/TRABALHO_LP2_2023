package com.lp2.leilao.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "lance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Lance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime data = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);

//    @ManyToOne
//    @JoinColumn(name = "cliente_cpf")
//    private Cliente cliente;
//
//    @ManyToOne
//    @JoinColumn(name = "leilao_id")
//    private Leilao leilao;
//
//    @ManyToOne
//    @JoinColumn(name = "produto_id")
//    private Produto produto;
//
//    public Produto getProduto() {
//        return produto;
//    }
//
//    public void setProduto(Produto produto) {
//        this.produto = produto;
//    }
//
//    public Leilao getLeilao() {
//        return leilao;
//    }
//
//    public void setLeilao(Leilao leilao) {
//        this.leilao = leilao;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public BigDecimal getValor() {
//        return valor;
//    }
//
//    public void setValor(BigDecimal valor) {
//        this.valor = valor;
//    }
//
//    public LocalDateTime getData() {
//        return data;
//    }
//
//    public void setData(LocalDateTime data) {
//        this.data = data;
//    }
}
