package com.lp2.leilao.model.dto.InstituicaoFinanceira;

import io.swagger.v3.oas.annotations.media.Schema;

public record CadastroInstituicaoFinanceiraDTO(

        @Schema(defaultValue = "24932237000179")
        String cnpj,
        @Schema(defaultValue = "Instituição Financeira LTDA")
        String nomeInstituicao

) {

}

