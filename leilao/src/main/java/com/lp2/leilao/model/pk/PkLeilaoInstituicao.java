package com.lp2.leilao.model.pk;

import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.Leilao;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PkLeilaoInstituicao implements Serializable {

    private static final long serialVersionUID = -1717749371789881687L;
    @ManyToOne
    private InstituicaoFinanceira instituicaoFinanceira;

    @ManyToOne
    private Leilao leilao;
}
