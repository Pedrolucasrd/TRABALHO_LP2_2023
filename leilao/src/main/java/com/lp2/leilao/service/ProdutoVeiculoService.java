package com.lp2.leilao.service;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.repository.LeilaoRepository;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import com.lp2.leilao.repository.ProdutoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoVeiculoService {
    @Autowired
    private ProdutoVeiculoRepository produtoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public ExibicaoProdutoVeiculoDTO criarProdutoVeiculo(Long leilaoId, CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        ProdutoVeiculo produtoVeiculo = new ProdutoVeiculo(cadastroProdutoVeiculoDTO, leilao.get());
        produtoRepository.save(produtoVeiculo);
        return new ExibicaoProdutoVeiculoDTO(produtoVeiculo);
    }

    public List<ExibicaoProdutoVeiculoDTO> listarProdutosVeiculo() {
        List<ProdutoVeiculo> produtoVeiculoLista = produtoRepository.findAll();
        return produtoVeiculoLista.stream().map(produtoVeiculo ->
                new ExibicaoProdutoVeiculoDTO(produtoVeiculo)).toList();
    }

    public ExibicaoProdutoVeiculoDTO atualizarProduto(Long idProduto, CadastroProdutoVeiculoDTO cadastroProdutoVeiculoDTO) {
        Optional<ProdutoVeiculo> produtoEncontrado = produtoRepository.findById(idProduto);
        if (produtoEncontrado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        ProdutoVeiculo produtoVeiculoAtualizado =
                new ProdutoVeiculo(produtoEncontrado.get(),
                        new ProdutoVeiculo(cadastroProdutoVeiculoDTO, produtoEncontrado.get().getLeilao()));
        produtoRepository.save(produtoVeiculoAtualizado);
        return new ExibicaoProdutoVeiculoDTO(produtoVeiculoAtualizado);
    }

    public ResponseEntity<String> deletarProdutoVeiculo(Long id) {
        if (produtoRepository.findById(id).isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            return ResponseEntity.ok().body("Produto inexistente!");
        }
        if (produtoRepository.findById(id).isEmpty()) {
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar produto!");
        }
    }
    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoVeiculo(Long idProduto, Long idLeilao) {

        Optional<ProdutoVeiculo> produtoVeiculo = produtoRepository.findById(idProduto);
        if(produtoVeiculo.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        produtoVeiculo.get().setLeilao(leilao.get());
        produtoRepository.save(produtoVeiculo.get());
        return new ExibicaoProdutoMudarLeilaoDTO(idProduto,idLeilao);

    }
}

