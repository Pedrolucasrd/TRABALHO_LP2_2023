package com.lp2.leilao.repository;

import com.lp2.leilao.model.Localizacao;
import com.lp2.leilao.model.pk.PkLocalizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, PkLocalizacao> {
}
