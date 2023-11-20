package com.lp2.leilao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoErros {

    @ExceptionHandler(SolicitacaoNaoEncontrada.class)
    public ResponseEntity<RespostaErro> tratarErro404NoSuchElementException(SolicitacaoNaoEncontrada ex) {
        RespostaErro respostaErro = new RespostaErro(ex.getMsg(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respostaErro);
    }
}
