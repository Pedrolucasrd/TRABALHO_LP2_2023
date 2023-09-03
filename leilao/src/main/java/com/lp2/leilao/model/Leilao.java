package com.lp2.leilao.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "leilao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leilao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private LocalDateTime dataInicio = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);
    private LocalDateTime dataFechamento;
    private StatusLeilao status;
}
