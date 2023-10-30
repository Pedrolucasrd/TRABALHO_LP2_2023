package com.lp2.leilao.model;


import com.lp2.leilao.model.pk.PkLeilaoInstituicao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "instituicao_leilao")
public class InstituicaoFinanceiraLeilao {
    @EmbeddedId
    private PkLeilaoInstituicao pkLeilaoInstituicao;
}
