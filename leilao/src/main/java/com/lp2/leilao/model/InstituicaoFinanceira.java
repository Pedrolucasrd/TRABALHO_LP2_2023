package com.lp2.leilao.model;

import com.lp2.leilao.model.dto.CadastroInstituicaoFinanceiraDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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


