package com.lp2.leilao.service;

import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.InstituicaoFinanceiraLeilao;
import com.lp2.leilao.model.Leilao;
import com.lp2.leilao.model.dto.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.pk.PkLeilaoInstituicao;
import com.lp2.leilao.repository.InstituicaoFinanceiraLeilaoRepository;
import com.lp2.leilao.repository.InstituicaoFinanceiraRepository;
import com.lp2.leilao.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InstituicaoFinanceiraService {
    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    @Autowired
    private InstituicaoFinanceiraLeilaoRepository instituicaoFinanceiraLeilaoRepository;

    @Autowired
    private LeilaoRepository leilaoRepository;

    public ExibicaoInstituicaoFinanceiraDTO criarInstituicaoFinanceira(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO ) {
        InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraRepository.save(
                new InstituicaoFinanceira(cadastroInstituicaoFinanceiraDTO)
        );
        return new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira);
    }

    public void vincularInstituicaoComLeilao(Long idLeilao, Long idInstituicao){
        InstituicaoFinanceiraLeilao instituicaoFinanceiraLeilao = new InstituicaoFinanceiraLeilao();
        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(idInstituicao);
        PkLeilaoInstituicao pkLeilaoInstituicao = new PkLeilaoInstituicao();
        pkLeilaoInstituicao.setLeilao(leilao.get());
        pkLeilaoInstituicao.setInstituicaoFinanceira(instituicaoFinanceira.get());
        instituicaoFinanceiraLeilao.setPkLeilaoInstituicao(pkLeilaoInstituicao);

        instituicaoFinanceiraLeilaoRepository.save(instituicaoFinanceiraLeilao);
    }


}
