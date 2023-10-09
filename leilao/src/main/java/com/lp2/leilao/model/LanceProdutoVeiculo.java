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
@Table(name = "LANCE_VEICULO")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LanceProdutoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private LocalDateTime data = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);

    @ManyToOne
    @JoinColumn(name = "produto_veiculo_id")
    private ProdutoVeiculo produtoVeiculo;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;


    public LanceProdutoVeiculo(ProdutoVeiculo produtoVeiculo, Cliente cliente, Double valor) {
        this.valor = valor;
        this.produtoVeiculo = produtoVeiculo;
        this.cliente = cliente;
    }
}
