package com.lp2.leilao.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class PkLocalizacao implements Serializable {
    private String cep;
    private Long numero;
}
