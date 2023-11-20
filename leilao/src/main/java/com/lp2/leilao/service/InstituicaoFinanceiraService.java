package com.lp2.leilao.service;

import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.AlteracaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.repository.InstituicaoFinanceiraRepository;
import com.lp2.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituicaoFinanceiraService {
    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;


    @Autowired
    private LeilaoRepository leilaoRepository;

    public ExibicaoInstituicaoFinanceiraDTO criarInstituicaoFinanceira(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO ) {
        InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraRepository.save(
                new InstituicaoFinanceira(cadastroInstituicaoFinanceiraDTO)
        );
        return new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira);
    }

    public AlteracaoInstituicaoFinanceiraDTO vincularInstituicaoComLeilao(Long idLeilao, Long idInstituicao){
        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Leilão não encontrada!");
        }
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(idInstituicao);
        if(instituicaoFinanceira.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Instituição Financeira não encontrada!");
        }
        instituicaoFinanceira.get().adicionarLeilao(leilao.get());
        return new AlteracaoInstituicaoFinanceiraDTO(instituicaoFinanceiraRepository.save(instituicaoFinanceira.get()),idLeilao);
    }

    public ExibicaoInstituicaoFinanceiraDTO consultainstituicaoPorId(Long id) {
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(id);
        if(instituicaoFinanceira.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Instituição Financeira não encontrada!");
        }
        return  new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira.get());
    }
    public List<ExibicaoInstituicaoFinanceiraDTO> consultainstituicaoPorLeilao(Long idLeilao) {
        List<InstituicaoFinanceira> instituicaoFinanceira =  instituicaoFinanceiraRepository.findByLeilaoId(idLeilao);
        if(instituicaoFinanceira.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Instituição Financeira não encontrada!");
        }
        return instituicaoFinanceira.stream().map(ExibicaoInstituicaoFinanceiraDTO::new).toList();
    }

    public ExibicaoInstituicaoFinanceiraDTO atualizarinstituicao(Long id, CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO) {
        Optional<InstituicaoFinanceira> instituicaoEncontrado = instituicaoFinanceiraRepository.findById(id);
        if(instituicaoEncontrado.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Instituição Financeira não encontrada!");
        }
        InstituicaoFinanceira instituicaoFinanceiraAtualizado = new InstituicaoFinanceira(instituicaoEncontrado.get(), cadastroInstituicaoFinanceiraDTO);
        instituicaoFinanceiraRepository.save(instituicaoFinanceiraAtualizado);
        return new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceiraAtualizado);
    }

    public ResponseEntity<String> deletarinstituicaoPorId(Long id) {
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(id);
        if(instituicaoFinanceira.isPresent()){
            for(Leilao leilao: instituicaoFinanceira.get().getLeilao()){
                if(leilao.getInstituicaoFinanceira().size()==1){
                    throw new SolicitacaoNaoEncontrada("O leilão com ID "+leilao.getId()+" possui apenas está instituição financeira!");
                }
            }
            instituicaoFinanceiraRepository.deleteById(id);
        } else {
            throw new SolicitacaoNaoEncontrada("Instituição inexistente!");
        }
        if (instituicaoFinanceiraRepository.findById(id).isEmpty()){
            return ResponseEntity.ok().body("Instituição financeira deletada com sucesso!");
        } else {
            throw new SolicitacaoNaoEncontrada("Erro ao deletar instituição financeira!");
        }
    }
}
