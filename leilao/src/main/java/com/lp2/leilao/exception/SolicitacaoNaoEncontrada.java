package com.lp2.leilao.exception;

public class SolicitacaoNaoEncontrada extends RuntimeException{
    private String msg;

    public SolicitacaoNaoEncontrada(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


}
