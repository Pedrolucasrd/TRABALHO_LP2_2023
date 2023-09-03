package com.lp2.leilao.controller;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void criarCliente (@RequestBody Cliente cliente){
        clienteService.criarCliente(cliente);
    }
}
