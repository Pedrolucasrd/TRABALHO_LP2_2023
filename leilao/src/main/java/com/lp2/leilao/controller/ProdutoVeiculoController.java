package com.lp2.leilao.controller;

import com.lp2.leilao.model.ProdutoVeiculo;
import com.lp2.leilao.model.dto.CadastroProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.CadastroProdutoVeiculoDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoMudarLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoVeiculoDTO;
import com.lp2.leilao.repository.ProdutoVeiculoRepository;
import com.lp2.leilao.service.ProdutoVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-veiculo")
public class ProdutoVeiculoController {

    @Autowired
    private ProdutoVeiculoRepository produtoRepository;

    @Autowired
    private ProdutoVeiculoService produtoService;

    @PostMapping("/criar/{leilaoId}")
    public ExibicaoProdutoVeiculoDTO adicionarProduto (@PathVariable Long leilaoId,
                                                       @RequestBody CadastroProdutoVeiculoDTO produtoVeiculo){
        return produtoService.criarProdutoVeiculo(leilaoId, produtoVeiculo);
    }

    @GetMapping("/listar-todos")
    public List<ExibicaoProdutoVeiculoDTO> listarProdutosVeiculo (){
        return produtoService.listarProdutosVeiculo();
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
