package com.lp2.leilao.model.dto.InstituicaoFinanceira;

import com.lp2.leilao.model.InstituicaoFinanceira;

public record AlteracaoInstituicaoFinanceiraDTO(

        Long id,
        String cnpj,
        String nomeInstituicao,
        Long leilaoId

) {
    public AlteracaoInstituicaoFinanceiraDTO(InstituicaoFinanceira instituicaoFinanceira, Long leilaoId) {
        this(instituicaoFinanceira.getId(),
                instituicaoFinanceira.getCnpj(),
                instituicaoFinanceira.getNomeInstituicao(),
                leilaoId);


    }


}
