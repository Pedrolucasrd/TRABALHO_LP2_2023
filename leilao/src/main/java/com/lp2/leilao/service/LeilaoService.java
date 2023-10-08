package com.lp2.leilao.service;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoCriadoDTO;
import com.lp2.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;


    public ExibicaoLeilaoCriadoDTO criarNovoLeilao (CadastroLeilaoDTO leilaoDTO){
        if(leilaoDTO.descricao().length() <= 15){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição muito curta!");
        }
        Leilao leilao = new Leilao(leilaoDTO);
        leilaoRepository.save(leilao);
        return new ExibicaoLeilaoCriadoDTO(leilao);
    }
}
