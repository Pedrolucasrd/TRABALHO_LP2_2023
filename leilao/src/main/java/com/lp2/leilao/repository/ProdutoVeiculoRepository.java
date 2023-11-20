package com.lp2.leilao.repository;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoVeiculoRepository extends JpaRepository <ProdutoVeiculo,Long> {

    @Query("SELECT pv FROM ProdutoInformatica pv " +
            "WHERE pv.leilao = :leilao " +
            "AND ((:minPreco IS NULL OR :maxPreco IS NULL) OR pv.precoInicial BETWEEN :minPreco AND :maxPreco) " +
            "AND ((:minPrecoLance IS NULL OR :maxPrecoLance IS NULL) OR EXISTS (SELECT lp FROM pv.lances lp WHERE lp.valor BETWEEN :minPrecoLance AND :maxPrecoLance)) " +
            "AND (:palavraChave IS NULL OR (pv.marca LIKE CONCAT('%', :palavraChave, '%') " +
            "OR pv.modelo LIKE CONCAT('%', :palavraChave, '%') " +
            "OR pv.descricao LIKE CONCAT('%', :palavraChave, '%')))")
    List<ProdutoInformatica> buscarPorFiltros(
            @Param("leilao") Leilao leilao,
            @Param("minPreco") Double minPreco,
            @Param("maxPreco") Double maxPreco,
            @Param("minPrecoLance") Double minPrecoLance,
            @Param("maxPrecoLance") Double maxPrecoLance,
            @Param("palavraChave") String palavraChave);
}
