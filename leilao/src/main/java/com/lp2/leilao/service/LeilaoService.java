package com.lp2.leilao.service;

import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.CadastroLeilaoDTO;
import com.lp2.leilao.model.dto.ExibicaoClienteDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoCriadoDTO;
import com.lp2.leilao.model.dto.ExibicaoLeilaoDTO;
import com.lp2.leilao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private LanceProdutoVeiculoRepository lanceProdutoVeiculoRepository;

    @Autowired
    private LanceProdutoInformaticaRepository lanceProdutoInformaticaRepository;

    @Autowired
    private ProdutoInformaticaRepository produtoInformaticaRepository;

    @Autowired
    private ProdutoVeiculoRepository produtoVeiculoRepository;


    public ExibicaoLeilaoCriadoDTO criarNovoLeilao (CadastroLeilaoDTO leilaoDTO){
        if(leilaoDTO.descricao().length() <= 15){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Descrição muito curta!");
        }
        Leilao leilao = new Leilao(leilaoDTO);
        leilaoRepository.save(leilao);
        return new ExibicaoLeilaoCriadoDTO(leilao);
    }

    public ExibicaoLeilaoDTO consultarLeilaoPorId(Long id) {
        Optional<Leilao> leilao = leilaoRepository.findById(id);
        if(leilao.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilao não encontrado!");
        }
        return new ExibicaoLeilaoDTO(leilao.get());
    }

    public ExibicaoLeilaoDTO atualizarLeilao(Long id, CadastroLeilaoDTO cadastroLeilaoDTO) {
        Optional<Leilao> leilaoEncontrado = leilaoRepository.findById(id);
        if(leilaoEncontrado.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leilão não encontrado!");
        }
        Leilao leilaoAtualizado = new Leilao(leilaoEncontrado.get(), cadastroLeilaoDTO);
        leilaoRepository.save(leilaoAtualizado);
        return new ExibicaoLeilaoDTO(leilaoAtualizado);
    }

    public ResponseEntity<String> deletarLeilaoPorId(Long id) {
        if (leilaoRepository.findById(id).isPresent()) {
            leilaoRepository.deleteById(id);
        } else {
            return ResponseEntity.ok().body("Leilão inexistente!");
        }
        if (leilaoRepository.findById(id).isEmpty()) {
            return ResponseEntity.ok().body("Leilão deletado com sucesso!");
        } else {
            return ResponseEntity.ok().body("Erro ao deletar leilão!");
        }
    }
}
