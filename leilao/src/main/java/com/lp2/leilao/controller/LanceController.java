package com.lp2.leilao.controller;

import com.lp2.leilao.model.CategoriaProduto;
import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoLanceProdutoDTO;
import com.lp2.leilao.model.dto.ExibicaoLanceProdutoVeiculoDTO;
import com.lp2.leilao.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "lance")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping("gerar-lance-produto-informatica/{produtoId}/{clienteCpf}/{valor}/{categoriaProduto}")
    public ExibicaoLanceProdutoDTO gerarLanceProdutoInformatica (@PathVariable Long produtoId,
                                                                 @PathVariable String clienteCpf,
                                                                 @PathVariable Double valor,
                                                                 @PathVariable CategoriaProduto categoriaProduto){
        return lanceService.gerarLanceProduto(produtoId, clienteCpf, valor,categoriaProduto);
    }

//    @PutMapping("/atualizar-lance-produto-informatica/{produtoId}/{clienteCpf}/{valor}/{categoriaProduto}")
//    public ExibicaoLanceProdutoDTO ataulizarLance(@PathVariable Long id , @RequestBody CadastroLan)







//    @PostMapping("gerar-lance-produto-veiculo/{produtoId}/{clienteCpf}/{valor}")
//    public ExibicaoLanceProdutoVeiculoDTO gerarLanceProdutoVeiculo (@PathVariable Long produtoId, @PathVariable String clienteCpf, @PathVariable Double valor){
//        return lanceService.gerarLanceProduto(produtoId, clienteCpf, valor, ca());
//    }
}
