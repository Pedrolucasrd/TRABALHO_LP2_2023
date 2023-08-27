package com.lp2.leilao.service;

import com.lp2.leilao.model.Produto;
import com.lp2.leilao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto atualizarProduto(Long idProduto, Produto produto){
        Optional<Produto> produtoEncontrado = produtoRepository.findById(idProduto);

        Produto produtoAtualizado = new Produto(produtoEncontrado.get(), produto);
        return produtoRepository.save(produtoAtualizado);
    }
}
