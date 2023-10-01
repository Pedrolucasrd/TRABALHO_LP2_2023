package com.lp2.leilao.controller;

import com.lp2.leilao.model.ProdutoInformatica;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import com.lp2.leilao.repository.ProdutoVeiculoRepository;
import com.lp2.leilao.service.ProdutoInformaticaService;
import com.lp2.leilao.service.ProdutoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-veiculo")
public class ProdutoVeiculoController {

    @Autowired
    private ProdutoVeiculoRepository produtoRepository;

    @Autowired
    private ProdutoVeiculoService produtoService;

    @PostMapping
    public ProdutoVeiculo addProduct (@RequestBody ProdutoVeiculo produtoVeiculo){
        return produtoRepository.save(produtoVeiculo);
    }

    @GetMapping
    public List<ProdutoVeiculo> listAllProdut (){
        return produtoRepository.findAll();
    }

    @PutMapping("/{id}")
    public ProdutoVeiculo updateProdut(@PathVariable Long id, @RequestBody ProdutoVeiculo produtoVeiculo){
        return produtoService.atualizarProduto(id, produtoVeiculo);
    }

    @DeleteMapping("/{id}")
    public void deleteProdut(@PathVariable Long id){
        produtoRepository.deleteById(id);
    }
}
