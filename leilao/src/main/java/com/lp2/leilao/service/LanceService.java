package com.lp2.leilao.service;

import com.lp2.leilao.model.Lance;
import com.lp2.leilao.repository.LanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    public void gerarlance(Lance lance){
        lanceRepository.save(lance);
    }
}
