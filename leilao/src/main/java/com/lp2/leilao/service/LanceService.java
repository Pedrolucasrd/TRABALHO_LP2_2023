package com.lp2.leilao.service;

import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.ExibicaoLanceProdutoInformaticaDTO;
import com.lp2.leilao.model.dto.ExibicaoLanceProdutoVeiculoDTO;
import com.lp2.leilao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LanceService {

    @Autowired
    private LanceProdutoInformaticaRepository lanceProdutoInformaticaRepository;

    @Autowired
    private LanceProdutoVeiculoRepository lanceProdutoVeiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoInformaticaRepository produtoInformaticaRepository;

    @Autowired
    private ProdutoVeiculoRepository produtoVeiculoRepository;
    public ExibicaoLanceProdutoInformaticaDTO gerarlanceProdutoInformatica(Long produtoId, String clienteCpf, Double valor){
        Optional<ProdutoInformatica> produtoInformatica = produtoInformaticaRepository.findById(produtoId);
        if(produtoInformatica.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceProdutoInformaticaRepository.findValorByProdutoInformatica(produtoInformatica.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>valor){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor abaixo do ultimo lance!");
        }
        LanceProdutoInformatica lanceProdutoInformatica = new LanceProdutoInformatica(produtoInformatica.get(),cliente.get(),valor);
        lanceProdutoInformaticaRepository.save(lanceProdutoInformatica);
        return new ExibicaoLanceProdutoInformaticaDTO(lanceProdutoInformatica);
    }

    public ExibicaoLanceProdutoVeiculoDTO gerarLanceProdutoVeiculo(Long produtoId, String clienteCpf, Double valor){
        Optional<ProdutoVeiculo> produtoVeiculo = produtoVeiculoRepository.findById(produtoId);
        if(produtoVeiculo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceProdutoVeiculoRepository.findValorByProdutoVeiculo(produtoVeiculo.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>valor){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor abaixo do ultimo lance!");
        }
        LanceProdutoVeiculo lanceProdutoVeiculo = new LanceProdutoVeiculo(produtoVeiculo.get(),cliente.get(),valor);
        lanceProdutoVeiculoRepository.save(lanceProdutoVeiculo);
        return new ExibicaoLanceProdutoVeiculoDTO(lanceProdutoVeiculo);
    }

}
