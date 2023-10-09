package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.CadastroProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.ExibicaoProdutoMudarLeilaoDTO;
import com.lp2.leilao.service.ProdutoInformaticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto-informatica")
public class ProdutoInformaticaController {


    @Autowired
    private ProdutoInformaticaService produtoService;

    @PostMapping("/criar/{leilaoId}")
    public ExibicaoProdutoInformaticaDTO criarProdutoInformatica (@PathVariable Long leilaoId, @RequestBody CadastroProdutoInformaticaDTO produtoInformatica){
        return produtoService.criarProdutoInformatica(leilaoId, produtoInformatica);
    }

    @GetMapping("/listar-todos")
    public List<ExibicaoProdutoInformaticaDTO> listarProdutosInformatica (){
        return produtoService.listarProdutosInformatica();
    }

    @PutMapping("atualizar/{id}")
    public ExibicaoProdutoInformaticaDTO atualizarProdutoInformatica(@PathVariable Long id, @RequestBody CadastroProdutoInformaticaDTO produtoInformatica){
        return produtoService.atualizarProduto(id, produtoInformatica);
    }

    @PutMapping("mudar-leilao/{idProduto}/{idLeilao}")
    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoInformatica(@PathVariable Long idProduto, @PathVariable Long idLeilao){
       return produtoService.mudarLeilaoProdutoInformatica(idProduto,idLeilao);
    }


    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarProdutoInformatica (@PathVariable Long id){
        return produtoService.deletarProdutoInformatica(id);
    }
}
