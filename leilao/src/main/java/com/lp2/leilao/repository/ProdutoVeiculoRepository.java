package com.lp2.leilao.repository;

import com.lp2.leilao.model.ProdutoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVeiculoRepository extends JpaRepository <ProdutoVeiculo,Long> {
}
