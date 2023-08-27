package com.lp2.leilao.controller;

import com.lp2.leilao.model.Produto;
import com.lp2.leilao.repository.ProdutoRepository;
import com.lp2.leilao.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Produto addProduct (@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> listAllProdut (){
        return produtoRepository.findAll();
    }

    @PutMapping("/{id}")
    public Produto updateProdut(@PathVariable Long id, @RequestBody Produto produto){
        return produtoService.atualizarProduto(id,produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProdut(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
