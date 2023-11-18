package com.lp2.leilao.util;

import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.enums.StatusLeilao;

import java.time.LocalDateTime;

public class ConfenciaStatusLeilao {

    public static StatusLeilao conferirStatus(Leilao leilao){
        LocalDateTime dataAtual = LocalDateTime.now();
        if(dataAtual.isBefore(leilao.getDataAbertura())){
            return StatusLeilao.EM_ABERTO;
        }else if(dataAtual.isAfter(leilao.getDataInicio()) && dataAtual.isBefore(leilao.getDataFechamento())){
            return StatusLeilao.EM_ANDAMENTO;
        }else {
            return StatusLeilao.FINALIZADO;
        }
    }
}
