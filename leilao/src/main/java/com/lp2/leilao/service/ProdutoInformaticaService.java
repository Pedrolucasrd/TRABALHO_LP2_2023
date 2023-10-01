package com.lp2.leilao.service;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoInformaticaService {

    @Autowired
    private ProdutoInformaticaRepository produtoRepository;

    public ProdutoInformatica atualizarProduto(Long idProduto, ProdutoInformatica produtoInformatica){
        Optional<ProdutoInformatica> produtoEncontrado = produtoRepository.findById(idProduto);

        ProdutoInformatica produtoInformaticaAtualizado = new ProdutoInformatica(produtoEncontrado.get(), produtoInformatica);
        return produtoRepository.save(produtoInformaticaAtualizado);
    }
}
