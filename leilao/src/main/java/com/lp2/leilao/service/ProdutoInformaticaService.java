package com.lp2.leilao.service;

import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.repository.LeilaoRepository;
import com.lp2.leilao.repository.ProdutoInformaticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoInformaticaService {

    @Autowired
    private ProdutoInformaticaRepository produtoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public ExibicaoProdutoInformaticaDTO criarProdutoInformatica(Long leilaoId, CadastroProdutoInformaticaDTO cadastroProdutoInformaticaDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        ProdutoInformatica produtoInformatica = new ProdutoInformatica(cadastroProdutoInformaticaDTO, leilao.get());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaDTO(produtoInformatica);
    }

    public List<ExibicaoProdutoInformaticaDTO> listarProdutosInformatica() {
        List<ProdutoInformatica> produtoInformaticaLista = produtoRepository.findAll();
        return produtoInformaticaLista
                .stream()
                .map(produtoInformatica -> new ExibicaoProdutoInformaticaDTO(produtoInformatica)).toList();
    }

    public ExibicaoProdutoInformaticaDTO atualizarProduto(Long idProduto, CadastroProdutoInformaticaDTO cadastroProdutoInformaticaDTO) {
        Optional<ProdutoInformatica> produtoEncontrado = produtoRepository.findById(idProduto);
        if (produtoEncontrado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }

        ProdutoInformatica produtoInformaticaAtualizado =
                new ProdutoInformatica(produtoEncontrado.get(),
                        new ProdutoInformatica(cadastroProdutoInformaticaDTO, produtoEncontrado.get().getLeilao()));
        produtoRepository.save(produtoInformaticaAtualizado);
        return new ExibicaoProdutoInformaticaDTO(produtoInformaticaAtualizado);
    }

    public ResponseEntity<String> deletarProdutoInformatica(Long id) {
        if (produtoRepository.findById(id).isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            return ResponseEntity.ok().body("Produto inexistente!");
        }
        if (produtoRepository.findById(id).isEmpty()) {
            return ResponseEntity.ok().body("Produto deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar produto!");
        }
    }

    public ExibicaoProdutoMudarLeilaoDTO mudarLeilaoProdutoInformatica(Long idProduto, Long idLeilao) {

        Optional<ProdutoInformatica> produtoInformatica = produtoRepository.findById(idProduto);
        if(produtoInformatica.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado!");
        }
        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty() ){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        produtoInformatica.get().setLeilao(leilao.get());
        produtoRepository.save(produtoInformatica.get());
        return new ExibicaoProdutoMudarLeilaoDTO(idProduto,idLeilao);

    }

    public ExibicaoProdutoInformaticaNotebookDTO criarProdutoInformaticaNotebook(Long leilaoId, CadastroProdutoInformaticaNotebookDTO cadastroProdutoInformaticaDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Notebook produtoInformatica = new Notebook(cadastroProdutoInformaticaDTO, leilao.get(), cadastroProdutoInformaticaDTO.tamanhoTela());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaNotebookDTO(produtoInformatica);
    }

    public ExibicaoProdutoInformaticaMonitorDTO criarProdutoInformaticaMonitor(Long leilaoId, CadastroProdutoInformaticaMonitorDTO cadastroProdutoInformaticaMonitorDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Monitor produtoInformatica = new Monitor(cadastroProdutoInformaticaMonitorDTO, leilao.get(), cadastroProdutoInformaticaMonitorDTO.tamanhoTela());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaMonitorDTO(produtoInformatica);
    }

    public ExibicaoProdutoInformaticaHubDTO criarProdutoInformaticaHub(Long leilaoId, CadastroProdutoInformaticaHubDTO cadastroProdutoInformaticaHubDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Hub produtoInformatica = new Hub(cadastroProdutoInformaticaHubDTO, leilao.get(), cadastroProdutoInformaticaHubDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaHubDTO(produtoInformatica);
    }

    public ExibicaoProdutoInformaticaSwitchDTO criarProdutoInformaticaSwitch(Long leilaoId, CadastroProdutoInformaticaSwitchDTO cadastroProdutoInformaticaSwitchDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Switch produtoInformatica = new Switch(cadastroProdutoInformaticaSwitchDTO, leilao.get(), cadastroProdutoInformaticaSwitchDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaSwitchDTO(produtoInformatica);
    }
    public ExibicaoProdutoInformaticaRoteadorDTO criarProdutoInformaticaRoteador(Long leilaoId, CadastroProdutoInformaticaRoteadorDTO cadastroProdutoInformaticaRoteadorDTO) {
        Optional<Leilao> leilao = leilaoRepository.findById(leilaoId);
        if (leilao.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Roteador produtoInformatica = new Roteador(cadastroProdutoInformaticaRoteadorDTO, leilao.get(), cadastroProdutoInformaticaRoteadorDTO.quantidadePortas());
        produtoRepository.save(produtoInformatica);
        return new ExibicaoProdutoInformaticaRoteadorDTO(produtoInformatica);
    }
}
