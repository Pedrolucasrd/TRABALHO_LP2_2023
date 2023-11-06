package com.lp2.leilao.controller;

import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ExibicaoClienteDTO criarCliente (@RequestBody CadastroClienteDTO cadastroClienteDTO){
        return clienteService.criarCliente(cadastroClienteDTO);
    }

    @GetMapping("procurar-por-cpf/{cpf}")
    public ExibicaoClienteDTO procurarClientePorCpf(@PathVariable String cpf){
        return clienteService.procurarClientePorCpf(cpf);
    }

    @GetMapping("listar-todos-clientes")
    public List<ExibicaoListagemClientesDTO> listarTodosClientes (){
        return clienteService.listarTodosClientes();
    }

    @PutMapping("atualizar-cliente/{cpf}")
    public ExibicaoClienteDTO atualizarCliente(@PathVariable String cpf,@RequestBody AtualizaClienteDTO atualizaClienteDTO){
        return clienteService.atualizarCliente(cpf, atualizaClienteDTO);
    }

    @GetMapping("procurar-lances-por-cpf/{cpf}")
    public List<ExibicaoLanceProdutoDTO> procurarLancesInformaticaPorCpf(@PathVariable String cpf){
        return clienteService.procurarLancesPorCpf(cpf);
    }


    @DeleteMapping("deletar/{cpf}")
    public ResponseEntity<String> deletarClientePeloCpf (@PathVariable String cpf){
        return clienteService.deletarClientePeloCpf(cpf);
    }
}
