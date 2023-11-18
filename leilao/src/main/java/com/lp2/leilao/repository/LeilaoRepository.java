package com.lp2.leilao.repository;


import com.lp2.leilao.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface LeilaoRepository extends JpaRepository<Leilao,Long> {
    List<Leilao> findAllByOrderByDataInicio();
}
