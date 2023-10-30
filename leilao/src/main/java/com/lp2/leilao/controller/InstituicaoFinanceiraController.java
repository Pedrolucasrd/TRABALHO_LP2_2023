package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.service.InstituicaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="instituicaofinanceira")
public class InstituicaoFinanceiraController {


    @Autowired
    private InstituicaoFinanceiraService instituicaofinanceiraService;


    @PostMapping("/criar")
    public ExibicaoInstituicaoFinanceiraDTO criar(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO) {
    return instituicaofinanceiraService.criarInstituicaoFinanceira(cadastroInstituicaoFinanceiraDTO);


    }

}
