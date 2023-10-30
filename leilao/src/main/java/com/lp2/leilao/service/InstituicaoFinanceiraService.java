package com.lp2.leilao.service;

import com.lp2.leilao.model.InstituicaoFinanceira;
import com.lp2.leilao.model.dto.CadastroInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.repository.InstituicaoFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituicaoFinanceiraService {
    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;

    public ExibicaoInstituicaoFinanceiraDTO criarInstituicaoFinanceira(CadastroInstituicaoFinanceiraDTO cadastroInstituicaoFinanceiraDTO ) {
        InstituicaoFinanceira instituicaoFinanceira = instituicaoFinanceiraRepository.save(
                new InstituicaoFinanceira(cadastroInstituicaoFinanceiraDTO)
        );
        return new ExibicaoInstituicaoFinanceiraDTO(instituicaoFinanceira);
    }


}
