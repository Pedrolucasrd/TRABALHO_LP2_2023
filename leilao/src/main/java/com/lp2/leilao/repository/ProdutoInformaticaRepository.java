package com.lp2.leilao.repository;

import com.lp2.leilao.model.ProdutoInformatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoInformaticaRepository extends JpaRepository<ProdutoInformatica, Long> {
}
