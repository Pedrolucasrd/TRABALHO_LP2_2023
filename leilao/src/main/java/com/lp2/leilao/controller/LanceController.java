package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.ExibicaoLanceProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.ExibicaoLanceProdutoVeiculoDTO;
import com.lp2.leilao.service.LanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "lance")
public class LanceController {

    @Autowired
    private LanceService lanceService;

    @PostMapping("gerar-lance-produto-informatica/{produtoId}/{clienteCpf}/{valor}")
    public ExibicaoLanceProdutoInformaticaDTO gerarLanceProdutoInformatica (@PathVariable Long produtoId, @PathVariable String clienteCpf, @PathVariable Double valor){
        return lanceService.gerarlanceProdutoInformatica(produtoId, clienteCpf, valor);
    }

    @PostMapping("gerar-lance-produto-veiculo/{produtoId}/{clienteCpf}/{valor}")
    public ExibicaoLanceProdutoVeiculoDTO gerarLanceProdutoVeiculo (@PathVariable Long produtoId, @PathVariable String clienteCpf, @PathVariable Double valor){
        return lanceService.gerarLanceProdutoVeiculo(produtoId, clienteCpf, valor);
    }
}
