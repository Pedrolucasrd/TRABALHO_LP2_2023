package com.lp2.leilao.model;


import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.util.FormatadorData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "leilao_instituicao",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "instituicao_id"))
    private List<InstituicaoFinanceira> instituicaoFinanceira;

    public Leilao(CadastroLeilaoDTO leilao) {
        this.nome = leilao.nome();
        this.descricao = leilao.descricao();
        this.dataInicio = FormatadorData.formatarData(leilao.dataInicio());
        this.dataFechamento = FormatadorData.formatarData(leilao.dataFechamento());
        this.status = StatusLeilao.EM_ABERTO;
    }

    public Leilao(Leilao leilao, CadastroLeilaoDTO cadastroLeilaoDTO) {
        this.id = leilao.getId();
        this.nome = cadastroLeilaoDTO.nome() != null ? cadastroLeilaoDTO.nome() : leilao.getNome();
        this.descricao = cadastroLeilaoDTO.descricao() != null ? cadastroLeilaoDTO.descricao() : leilao.getDescricao();
        this.dataAbertura = leilao.getDataAbertura();
        this.dataInicio = leilao.getDataInicio();
        this.dataFechamento = leilao.getDataFechamento();
        this.status = leilao.getStatus();
    }
}
