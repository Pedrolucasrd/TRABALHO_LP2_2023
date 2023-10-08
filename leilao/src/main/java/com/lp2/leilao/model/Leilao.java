package com.lp2.leilao.model;


import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
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
    private String nome;
    private String descricao;
    private LocalDateTime dataAbertura = LocalDateTime.now(ZoneId.systemDefault()).minusHours(3);
    private LocalDateTime dataInicio;
    private LocalDateTime dataFechamento;
    private StatusLeilao status;

    public Leilao(CadastroLeilaoDTO leilao) {
        this.nome = leilao.nome();
        this.descricao = leilao.descricao();
        this.status = StatusLeilao.EM_ABERTO;
    }
}
