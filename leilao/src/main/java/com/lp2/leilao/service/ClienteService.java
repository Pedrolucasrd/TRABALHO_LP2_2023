package com.lp2.leilao.service;


import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void criarCliente (Cliente cliente){
        clienteRepository.save(cliente);
    }

}
