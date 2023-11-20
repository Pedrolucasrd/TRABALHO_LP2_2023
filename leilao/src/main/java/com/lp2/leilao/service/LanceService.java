package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.lance.ExibicaoLanceProdutoDTO;
import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
    public ExibicaoLanceProdutoDTO gerarlanceProdutoInformatica(Long produtoId, String clienteCpf, Double valor){
        Optional<ProdutoInformatica> produtoInformatica = produtoInformaticaRepository.findById(produtoId);

        if(produtoInformatica.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        if(produtoInformatica.get().getPrecoInicial()>valor){
            throw new SolicitacaoNaoEncontrada("É necessario inserir um valor maior do que o preço inicial do produto!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceProdutoInformaticaRepository.findValorByProdutoInformatica(produtoInformatica.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>=valor){
            throw new SolicitacaoNaoEncontrada("Valor abaixo do ultimo lance!");
        }
        LanceProdutoInformatica lanceProdutoInformatica = new LanceProdutoInformatica(produtoInformatica.get(),cliente.get(),valor);
        lanceProdutoInformaticaRepository.save(lanceProdutoInformatica);
        return new ExibicaoLanceProdutoDTO(lanceProdutoInformatica);
    }

    public ExibicaoLanceProdutoDTO gerarLanceProdutoVeiculo(Long produtoId, String clienteCpf, Double valor){
        Optional<ProdutoVeiculo> produtoVeiculo = produtoVeiculoRepository.findById(produtoId);
        if(produtoVeiculo.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        if(produtoVeiculo.get().getPrecoInicial()>valor){
            throw new SolicitacaoNaoEncontrada("É necessario inserir um valor maior do que o preço inicial do produto!");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteCpf);
        if(cliente.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        Double ultimoMaiorLance = lanceProdutoVeiculoRepository.findValorByProdutoVeiculo(produtoVeiculo.get().getId());
        ultimoMaiorLance = ultimoMaiorLance != null ? ultimoMaiorLance : 0D;
        if(ultimoMaiorLance>=valor){
            throw new SolicitacaoNaoEncontrada("Valor abaixo do ultimo lance!");
        }
        LanceProdutoVeiculo lanceProdutoVeiculo = new LanceProdutoVeiculo(produtoVeiculo.get(),cliente.get(),valor);
        lanceProdutoVeiculoRepository.save(lanceProdutoVeiculo);
        return new ExibicaoLanceProdutoDTO(lanceProdutoVeiculo);
    }

    public ExibicaoLanceProdutoDTO gerarLanceProduto (Long produtoId, String clienteCpf, Double valor, CategoriaProduto categoriaProduto){
        switch (categoriaProduto){
            case VEICULO -> {
                return gerarLanceProdutoVeiculo(produtoId,clienteCpf,valor);
            }
            case INFORMATICA -> {
                return gerarlanceProdutoInformatica(produtoId, clienteCpf, valor);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao gerar lance!");
    }

    public List<ExibicaoLanceProdutoDTO> historicoLance(Long produtoId, CategoriaProduto categoriaProduto) {
        switch (categoriaProduto){
            case VEICULO -> {
                return consultarHistoricoVeiculo(produtoId);
            }
            case INFORMATICA -> {
                return consultarHistoricoInformatica(produtoId);
            }
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao gerar lance!");
    }

    private List<ExibicaoLanceProdutoDTO> consultarHistoricoVeiculo(Long produtoId) {
        Optional<ProdutoVeiculo> produtoVeiculo = produtoVeiculoRepository.findById(produtoId);
        if(produtoVeiculo.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        List<LanceProdutoVeiculo> lanceProdutoVeiculo = lanceProdutoVeiculoRepository.findByProdutoVeiculo(produtoVeiculo.get());
        return lanceProdutoVeiculo.stream().map(ExibicaoLanceProdutoDTO::new).toList();
    }
    private List<ExibicaoLanceProdutoDTO> consultarHistoricoInformatica(Long produtoId) {
        Optional<ProdutoInformatica> produtoInformatica = produtoInformaticaRepository.findById(produtoId);
        if(produtoInformatica.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
        }
        List<LanceProdutoInformatica> lanceProdutoInformatica = lanceProdutoInformaticaRepository.findByProdutoInformatica(produtoInformatica.get());
        return lanceProdutoInformatica.stream().map(ExibicaoLanceProdutoDTO::new).toList();
    }
}
