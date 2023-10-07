package com.lp2.leilao.service;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;


    public void criarNovoLeilao (Leilao leilao){
        leilaoRepository.save(leilao);
    }
}
