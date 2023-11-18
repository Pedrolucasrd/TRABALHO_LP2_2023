package com.lp2.leilao.repository;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.ProdutoInformatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceProdutoInformaticaRepository extends JpaRepository<LanceProdutoInformatica, Long> {
    List<LanceProdutoInformatica> findAllByCliente(Cliente cliente);

    @Query(value = "SELECT VALOR FROM LANCE_INFORMATICA WHERE produto_informatica_id = ?1 ORDER BY VALOR DESC LIMIT 1",nativeQuery = true)
    Double findValorByProdutoInformatica(Long id);

    LanceProdutoInformatica findByProdutoInformatica(ProdutoInformatica produtoInformatica);
}
