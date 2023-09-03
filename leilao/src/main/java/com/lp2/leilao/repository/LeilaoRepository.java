package com.lp2.leilao.repository;


import com.lp2.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao,Long> {
}
