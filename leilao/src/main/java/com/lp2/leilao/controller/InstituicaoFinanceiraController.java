package com.lp2.leilao.controller;

import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.InstituicaoFinanceiraLeilao;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.pk.PkLeilaoInstituicao;
import com.lp2.leilao.repository.InstituicaoFinanceiraLeilaoRepository;
import com.lp2.leilao.repository.InstituicaoFinanceiraRepository;
import com.lp2.leilao.repository.LeilaoRepository;
import com.lp2.leilao.service.InstituicaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="instituicao-financeira")
public class InstituicaoFinanceiraController {


    @Autowired
    private InstituicaoFinanceiraService instituicaofinanceiraService;

    @PostMapping("/criar")
    public ExibicaoInstituicaoFinanceiraDTO criar(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO) {
    return instituicaofinanceiraService.criarInstituicaoFinanceira(cadastroInstituicaoFinanceiraDTO);
    }

    @PostMapping("vincular-leilao-instituicao/{idLeilao}/{idInstituicao}")
    public void vincularInstituicaoComLeilao(@PathVariable Long idLeilao, @PathVariable Long idInstituicao){
        instituicaofinanceiraService.vincularInstituicaoComLeilao(idLeilao, idInstituicao);
    }
}
