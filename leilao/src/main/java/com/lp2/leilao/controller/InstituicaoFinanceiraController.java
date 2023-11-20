package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.InstituicaoFinanceira.AlteracaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.service.InstituicaoFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public AlteracaoInstituicaoFinanceiraDTO vincularInstituicaoComLeilao(@PathVariable Long idLeilao, @PathVariable Long idInstituicao){
        return instituicaofinanceiraService.vincularInstituicaoComLeilao(idLeilao, idInstituicao);
    }

    @GetMapping("/consultar/{id}")
    public ExibicaoInstituicaoFinanceiraDTO consultainstituicaoPorId(@PathVariable Long id){
        return instituicaofinanceiraService.consultainstituicaoPorId(id);
    }
    @GetMapping("/consultar/leilao/{id}")
    public List<ExibicaoInstituicaoFinanceiraDTO> consultainstituicaoPorLeilao(@PathVariable Long id){
        return instituicaofinanceiraService.consultainstituicaoPorLeilao(id);
    }

    @PutMapping("/atualizar/{id}")
    public ExibicaoInstituicaoFinanceiraDTO atualizarinstituicao(@PathVariable Long id, @RequestBody CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO){
        return instituicaofinanceiraService.atualizarinstituicao(id, cadastroInstituicaoFinanceiraDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarinstituicaoPorId(@PathVariable Long id){
        return instituicaofinanceiraService.deletarinstituicaoPorId(id);
    }

}
