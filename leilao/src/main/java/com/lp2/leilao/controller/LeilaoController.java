package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoCriadoDTO;
import com.lp2.leilao.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "leilao")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping("/criar")
    public ExibicaoLeilaoCriadoDTO criarLeilao (@RequestBody CadastroLeilaoDTO leilao){
        return leilaoService.criarNovoLeilao(leilao);
    }


}
