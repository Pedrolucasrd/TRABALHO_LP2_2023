package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoCriadoDTO;
import com.lp2.leilao.model.dto.DetalhamentoLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoDTO;
import com.lp2.leilao.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "leilao")
public class LeilaoController {

    @Autowired
    private LeilaoService leilaoService;

    @PostMapping("/criar")
    public ExibicaoLeilaoCriadoDTO criarLeilao (@RequestBody CadastroLeilaoDTO leilao){
        return leilaoService.criarNovoLeilao(leilao);
    }

//    @GetMapping("/consultar/{id}")
//    public ExibicaoLeilaoDTO consultarLeilaoPorId(@PathVariable Long id){
//        return leilaoService.consultarLeilaoPorId(id);
//    }

    @GetMapping("/detalhamento/{id}")
    public DetalhamentoLeilaoDTO consultarLeilaoPorId(@PathVariable Long id){
        return leilaoService.consultarLeilaoPorId(id);
    }
//    @PutMapping("/atualizar/{id}")
//    public ExibicaoLeilaoDTO atualizarLeilao(@PathVariable Long id, @RequestBody CadastroLeilaoDTO cadastroLeilaoDTO){
//        return leilaoService.atualizarLeilao(id, cadastroLeilaoDTO);
//    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLeilaoPorId (@PathVariable Long id){
        return leilaoService.deletarLeilaoPorId(id);
    }

    @GetMapping("listar")
    public List<ExibicaoLeilaoDTO> listarLeiloes (){
        return leilaoService.listarLeiloes();
    }


}
