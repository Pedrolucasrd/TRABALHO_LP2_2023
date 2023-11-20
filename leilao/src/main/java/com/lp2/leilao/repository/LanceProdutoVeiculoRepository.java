package com.lp2.leilao.repository;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.LanceProdutoVeiculo;
import com.lp2.leilao.model.ProdutoVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceProdutoVeiculoRepository extends JpaRepository<LanceProdutoVeiculo, Long> {

    List<LanceProdutoVeiculo> findAllByCliente(Cliente cliente);

    @Query(value = "SELECT VALOR FROM LANCE_VEICULO WHERE produto_veiculo_id = ?1 ORDER BY VALOR DESC LIMIT 1",nativeQuery = true)
    Double findValorByProdutoVeiculo(Long id);

    List<LanceProdutoVeiculo> findByProdutoVeiculo(ProdutoVeiculo produtoVeiculo);
}
