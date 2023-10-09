package com.lp2.leilao.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Entity
@Table(name = "lance_informatica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LanceProdutoInformatica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime data = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);

    @ManyToOne
    @JoinColumn(name = "produto_informatica_id")
    private ProdutoInformatica produtoInformatica;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;


    public LanceProdutoInformatica(ProdutoInformatica produtoInformatica, Cliente cliente, Double valor) {
        this.valor = valor;
        this.produtoInformatica = produtoInformatica;
        this.cliente = cliente;
    }
}
