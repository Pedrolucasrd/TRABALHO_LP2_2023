package com.lp2.leilao.controller;

import com.lp2.leilao.model.Motocicleta;
import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.repository.GenericRepository;
import com.lp2.leilao.repository.ProdutoVeiculoRepository;
import com.lp2.leilao.service.ProdutoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produto-veiculo")
public class ProdutoVeiculoController {

    @Autowired
    private ProdutoVeiculoRepository produtoRepository;

    @Autowired
    private ProdutoVeiculoService produtoService;


    @PostMapping("/criar/{leilaoId}")
    public ProdutoVeiculo adicionarProduto (@PathVariable Long leilaoId,
                                                       @RequestBody Motocicleta produtoVeiculo){
        return produtoRepository.save(produtoVeiculo);
    }
    @PostMapping("/criar/motocicleta/{leilaoId}")
    public ExibicaoProdutoVeiculoMotocicletaDTO adicionarProdutoMotocicleta (@PathVariable Long leilaoId,
                                                       @RequestBody CadastroProdutoVeiculoMotocicletaDTO produtoVeiculo){
        return produtoService.criarProdutoVeiculoMotocicleta(leilaoId, produtoVeiculo);
    }

    @PostMapping("/criar/carro/{leilaoId}")
    public ExibicaoProdutoVeiculoCarroDTO adicionarProdutoCarro (@PathVariable Long leilaoId,
                                                                  @RequestBody CadastroProdutoVeiculoCarroDTO produtoVeiculo){
        return produtoService.criarProdutoVeiculoCarro(leilaoId, produtoVeiculo);
    }

    @PostMapping("/criar/caminhao/{leilaoId}")
    public ExibicaoProdutoVeiculoCaminhaoDTO adicionarProdutoCaminhao (@PathVariable Long leilaoId,
                                                                             @RequestBody CadastroProdutoVeiculoCaminhaoDTO produtoVeiculo) {
        return produtoService.criarProdutoVeiculoCaminhao(leilaoId, produtoVeiculo);


    }
    @PostMapping("/criar/utilitario/{leilaoId}")
    public ExibicaoProdutoVeiculoUtilitarioDTO adicionarProdutoUtilitario (@PathVariable Long leilaoId,
                                                                       @RequestBody CadastroProdutoVeiculoUtilitarioDTO produtoVeiculo) {
        return produtoService.criarProdutoVeiculoUtilitario(leilaoId, produtoVeiculo);


    }

    @GetMapping("/listar-todos")
    public List<ExibicaoProdutoVeiculoDTO> listarProdutosVeiculo (){
        return produtoService.listarProdutosVeiculo();
    }

    @GetMapping("{idProduto}")
    public Object selecionarProdutoVeiculo (@PathVariable Long idProduto){
        return produtoService.selecionarProdutoVeiculo(idProduto);
    }

    @PutMapping("atualizar/{id}")
    public ExibicaoProdutoVeiculoDTO atualizarProdutoVeiculo(@PathVariable Long id, @RequestBody CadastroProdutoVeiculoDTO produtoVeiculo){
        return produtoService.atualizarProduto(id, produtoVeiculo);
    }

    @PutMapping("mudar-leilao/{idProduto}/{idLeilao}")
    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoVeiculo(@PathVariable Long idProduto, @PathVariable Long idLeilao){
        return produtoService.mudarLeilaoProdutoVeiculo(idProduto,idLeilao);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarProdutoVeiculo(@PathVariable Long id){
        return produtoService.deletarProdutoVeiculo(id);
    }
}
