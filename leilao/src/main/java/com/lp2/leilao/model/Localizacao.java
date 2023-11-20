package com.lp2.leilao.model;


import com.lp2.leilao.model.dto.LocalizacaoDTO;
import com.lp2.leilao.model.pk.PkLocalizacao;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@IdClass(PkLocalizacao.class)
public class Localizacao {
    @Id
    private Long numero;
    @Id
    private String cep;


    private String endereco;

    private String cidade;

    private String estado;

    public Localizacao(LocalizacaoDTO localizacao) {
        this.numero = localizacao.numero();
        this.cep = localizacao.cep();
        this.endereco = localizacao.endereco();
        this.cidade = localizacao.cidade();
        this.estado = localizacao.estado();
    }
}
