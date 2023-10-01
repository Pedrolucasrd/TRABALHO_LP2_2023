package com.lp2.leilao.controller;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import com.lp2.leilao.service.ProdutoInformaticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-informatica")
public class ProdutoInformaticaController {

    @Autowired
    private ProdutoInformaticaRepository produtoRepository;

    @Autowired
    private ProdutoInformaticaService produtoService;

    @PostMapping
    public ProdutoInformatica addProduct (@RequestBody ProdutoInformatica produtoInformatica){
        return produtoRepository.save(produtoInformatica);
    }

    @GetMapping
    public List<ProdutoInformatica> listAllProdut (){
        return produtoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ProdutoInformatica updateProdut(@PathVariable Long id, @RequestBody ProdutoInformatica produtoInformatica){
        return produtoService.atualizarProduto(id, produtoInformatica);
    }

    @DeleteMapping("/{id}")
    public void deleteProdut(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
