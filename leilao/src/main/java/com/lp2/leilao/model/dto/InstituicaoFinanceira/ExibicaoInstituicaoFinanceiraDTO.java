package com.lp2.leilao.model.dto.InstituicaoFinanceira;

import com.lp2.leilao.model.InstituicaoFinanceira;

public record ExibicaoInstituicaoFinanceiraDTO(

        Long id,
        String cnpj,
        String nomeInstituicao

) {
    public ExibicaoInstituicaoFinanceiraDTO(InstituicaoFinanceira instituicaoFinanceira) {
        this(instituicaoFinanceira.getId(),
                instituicaoFinanceira.getCnpj(),
                instituicaoFinanceira.getNomeInstituicao());


    }


}
