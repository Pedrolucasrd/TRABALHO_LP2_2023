package com.lp2.leilao.service;


import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.LanceProdutoVeiculo;
import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.repository.ClienteRepository;
import com.lp2.leilao.repository.LanceProdutoInformaticaRepository;
import com.lp2.leilao.repository.LanceProdutoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private LanceProdutoInformaticaRepository lanceProdutoInformaticaRepository;

    @Autowired
    private LanceProdutoVeiculoRepository lanceProdutoVeiculoRepository;

    public ExibicaoClienteDTO criarCliente (CadastroClienteDTO cadastroClienteDTO){
        Cliente cliente = new Cliente(cadastroClienteDTO);
        clienteRepository.save(cliente);
        return new ExibicaoClienteDTO(cliente);
    }

    public ExibicaoClienteDTO procurarClientePorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        return new ExibicaoClienteDTO(cliente.get());
    }

    public List<ExibicaoListagemClientesDTO> listarTodosClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes.stream()
                .map(cliente ->
                        new ExibicaoListagemClientesDTO(cliente)).toList();
    }

    public ExibicaoClienteDTO atualizarCliente(String cpf, AtualizaClienteDTO atualizaClienteDTO) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(cpf);
        if(clienteEncontrado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        Cliente clienteAtualizado = new Cliente(clienteEncontrado.get(), atualizaClienteDTO);
        clienteRepository.save(clienteAtualizado);
        return new ExibicaoClienteDTO(clienteAtualizado);
    }

    public List<ExibicaoLanceProdutoInformaticaDTO> procurarLancesInformaticaPorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        List<LanceProdutoInformatica> listaLances = lanceProdutoInformaticaRepository.findAllByCliente(cliente.get());
        return listaLances.stream().map(lanceProdutoInformatica
                -> new ExibicaoLanceProdutoInformaticaDTO(lanceProdutoInformatica)).toList();
    }

    public List<ExibicaoLanceProdutoVeiculoDTO> procurarLancesVeiculoPorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        List<LanceProdutoVeiculo> listaLances = lanceProdutoVeiculoRepository.findAllByCliente(cliente.get());
        return listaLances.stream().map(lanceProdutoVeiculo
                -> new ExibicaoLanceProdutoVeiculoDTO(lanceProdutoVeiculo)).toList();
    }

    public ResponseEntity<String> deletarClientePeloCpf(String cpf) {
        if (clienteRepository.findById(cpf).isPresent()) {
            clienteRepository.deleteById(cpf);
        } else {
            return ResponseEntity.ok().body("Cliente inexistente!");
        }
        if (clienteRepository.findById(cpf).isEmpty()) {
            return ResponseEntity.ok().body("Cliente deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar cliente!");
        }
    }
}
