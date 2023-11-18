package com.lp2.leilao.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatadorData {
    public static LocalDateTime formatarData(String data){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dataFormatada = LocalDateTime.parse(data, formatador);
        return dataFormatada;
    }
}
