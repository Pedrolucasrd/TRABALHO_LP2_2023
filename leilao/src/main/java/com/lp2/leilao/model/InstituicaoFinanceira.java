package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.InstituicaoFinanceira.CadastroInstituicaoFinanceiraDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instituicao_financeira")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituicaoFinanceira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String cnpj;
    private String nomeInstituicao;

    @ManyToMany
    @JoinTable(
            name = "leilao_instituicao",
            joinColumns = @JoinColumn(name = "instituicao_id"),
            inverseJoinColumns = @JoinColumn(name = "leilao_id"))
    private List<Leilao> leilao;

    public void adicionarLeilao(Leilao leilao) {
        if (this.leilao == null) {
            this.leilao = new ArrayList<>();
        }
        this.leilao.add(leilao);
    }

    public InstituicaoFinanceira(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO) {
         this.cnpj=cadastroInstituicaoFinanceiraDTO.cnpj();
         this.nomeInstituicao=cadastroInstituicaoFinanceiraDTO.nomeInstituicao();
    }

    public InstituicaoFinanceira(InstituicaoFinanceira instituicaoFinanceira, CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO) {
        this.id = instituicaoFinanceira.getId();
        this.cnpj = cadastroInstituicaoFinanceiraDTO.cnpj() != null ? cadastroInstituicaoFinanceiraDTO.cnpj() : instituicaoFinanceira.getCnpj();
        this.nomeInstituicao = cadastroInstituicaoFinanceiraDTO.nomeInstituicao() != null ? cadastroInstituicaoFinanceiraDTO.nomeInstituicao() : instituicaoFinanceira.getNomeInstituicao();
    }
}


