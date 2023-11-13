package com.lp2.leilao.repository;

import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstituicaoFinanceiraRepository extends JpaRepository <InstituicaoFinanceira, Long> {
    List<InstituicaoFinanceira> findByLeilao(Leilao leilao);

    @Query("SELECT i FROM InstituicaoFinanceira i JOIN i.leilao l WHERE l.id = :leilaoId")
    List<InstituicaoFinanceira> findByLeilaoId(@Param("leilaoId") Long leilaoId);

}
