package com.lp2.leilao.service;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import com.lp2.leilao.repository.ProdutoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProdutoVeiculoService {
    @Autowired
    private ProdutoVeiculoRepository produtoVeiculoRepository;

    public ProdutoVeiculo atualizarProduto(Long idProduto, ProdutoVeiculo produtoVeiculo){
        Optional<ProdutoVeiculo> produtoEncontrado = produtoVeiculoRepository.findById(idProduto);

        ProdutoVeiculo produtoVeiculoAtualizado = new ProdutoVeiculo(produtoEncontrado.get(), produtoVeiculo);
        return produtoVeiculoRepository.save(produtoVeiculoAtualizado);
    }
}

