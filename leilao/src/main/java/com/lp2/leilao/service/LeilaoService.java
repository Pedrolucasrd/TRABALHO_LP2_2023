package com.lp2.leilao.service;

import com.google.gson.Gson;
import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.*;
import com.lp2.leilao.model.dto.*;
import com.lp2.leilao.model.dto.InstituicaoFinanceira.ExibicaoInstituicaoFinanceiraDTO;
import com.lp2.leilao.model.dto.lance.LanceGanhadorDTO;
import com.lp2.leilao.model.dto.leilao.*;
import com.lp2.leilao.model.enums.CategoriaProduto;
import com.lp2.leilao.model.enums.StatusLeilao;
import com.lp2.leilao.repository.*;
import com.lp2.leilao.util.ConfenciaStatusLeilao;
import com.lp2.leilao.util.FormatadorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private ProdutoInformaticaRepository produtoInformaticaRepository;

    @Autowired
    private ProdutoVeiculoRepository produtoVeiculoRepository;

    @Autowired
    private InstituicaoFinanceiraService instituicaoFinanceiraService;
    @Autowired
    private LocalizacaoRepository localizacaoRepository;
    @Autowired
    private InstituicaoFinanceiraRepository instituicaoFinanceiraRepository;


    public ExibicaoLeilaoCriadoDTO criarNovoLeilao (CadastroLeilaoDTO leilaoDTO){
        LocalDateTime dataInicio = FormatadorData.formatarData(leilaoDTO.dataInicio());
        LocalDateTime dataFechamento = FormatadorData.formatarData(leilaoDTO.dataFechamento());
        if(leilaoDTO.descricao().length() <= 15){
            throw new SolicitacaoNaoEncontrada("Descrição muito curta!");
        }

        if(dataFechamento.isBefore(dataInicio)){
            throw new SolicitacaoNaoEncontrada("Data de inicio não pode ser antes da de fechamento!");
        }
        Optional<InstituicaoFinanceira> instituicaoFinanceira = instituicaoFinanceiraRepository.findById(leilaoDTO.instituicaoFinanceira());

        if(instituicaoFinanceira.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Instituição financeira não encontrada!");
        }

        Leilao leilao = new Leilao(leilaoDTO);
        leilao.setInstituicaoFinanceira(Collections.singletonList(instituicaoFinanceira.get()));
        Localizacao localizacaoNova = new Localizacao(leilaoDTO.localizacao());
        localizacaoRepository.save(localizacaoNova);
        leilao.setLocalizacao(localizacaoNova);
        leilaoRepository.save(leilao);
        return new ExibicaoLeilaoCriadoDTO(leilao);
    }

//    public ExibicaoLeilaoDTO consultarLeilaoPorId(Long id) {
//        Optional<Leilao> leilao = leilaoRepository.findById(id);
//        if(leilao.isEmpty()){
//            throw new SolicitacaoNaoEncontrada("Leilao não encontrado!");
//        }
//        return new ExibicaoLeilaoDTO(leilao.get());
//    }

    public Object consultarLeilaoPorId(Long id) {
        Optional<Leilao> leilao = leilaoRepository.findById(id);
        if(leilao.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Leilao não encontrado!");
        }
//        StatusLeilao statusLeilao = StatusLeilao.FINALIZADO;
        StatusLeilao statusLeilao = ConfenciaStatusLeilao.conferirStatus(leilao.get());

        List<ProdutoInformatica> listaProdutoInformatica = produtoInformaticaRepository.findAll();
        List<ProdutoVeiculo> listaProdutoVeiculo = produtoVeiculoRepository.findAll();

        List<ExibicaoInstituicaoFinanceiraDTO> listaEntidadeFinanceira = new ArrayList<>(instituicaoFinanceiraService.consultainstituicaoPorLeilao(leilao.get().getId()));


        if(statusLeilao.equals(StatusLeilao.FINALIZADO)){
            List<InformacaoBasicaVencedorProdutoDTO> listaProdutos = new ArrayList<>(listaProdutoInformatica.stream().map(this::consultarVencedor).toList());
            listaProdutos.sort((produto1, produto2) ->
                    produto1.descricao().compareToIgnoreCase(produto2.descricao()));
            return new DetalhamentoLeilaoFinalizadoDTO(leilao.get(),listaProdutos,listaEntidadeFinanceira);
        }else {
            List<InformacaoBasicaProdutoDTO> listaProdutos = new ArrayList<>();
            listaProdutos.addAll(listaProdutoInformatica.stream().map(InformacaoBasicaProdutoDTO::new).toList());
            listaProdutos.addAll(listaProdutoVeiculo.stream().map(InformacaoBasicaProdutoDTO::new).toList());
            listaProdutos.sort((produto1, produto2) ->
                    produto1.descricao().compareToIgnoreCase(produto2.descricao()));
            return new DetalhamentoLeilaoDTO(leilao.get(),listaProdutos,listaEntidadeFinanceira);

        }

    }

    public InformacaoBasicaVencedorProdutoDTO consultarVencedor (ProdutoInformatica produtoInformatica){
        LanceProdutoInformatica lanceGanhador = new LanceProdutoInformatica();
        lanceGanhador.setValor(0D);
        for(LanceProdutoInformatica lanceProdutoInformatica : produtoInformatica.getLances()){
            if(lanceProdutoInformatica.getValor()>lanceGanhador.getValor()){
                lanceGanhador = lanceProdutoInformatica;
            }
        }
        GanhadorLeilaoDTO ganhadorLeilaoDTO = new GanhadorLeilaoDTO(lanceGanhador.getCliente(),new LanceGanhadorDTO(lanceGanhador));
        return new InformacaoBasicaVencedorProdutoDTO(produtoInformatica,ganhadorLeilaoDTO);
    }

//    public ExibicaoLeilaoDTO atualizarLeilao(Long id, CadastroLeilaoDTO cadastroLeilaoDTO) {
//        Optional<Leilao> leilaoEncontrado = leilaoRepository.findById(id);
//        if(leilaoEncontrado.isEmpty()){
//            throw new SolicitacaoNaoEncontrada("Leilão não encontrado!");
//        }
//        Leilao leilaoAtualizado = new Leilao(leilaoEncontrado.get(), cadastroLeilaoDTO);
//        leilaoRepository.save(leilaoAtualizado);
//        return new ExibicaoLeilaoDTO(leilaoAtualizado);
//    }

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

    public List<ExibicaoLeilaoDTO> listarLeiloes() {
        return leilaoRepository.findAllByOrderByDataInicio().stream().map(ExibicaoLeilaoDTO::new).toList();
    }


    public Object buscarProdutos(Long idLeilao,
                                                           Double valorMinimo,
                                                           Double valorMaximo,
                                 Double valorMinimoLance,
                                 Double valorMaximoLance,
                                                           String palavraChave,
                                                           CategoriaProduto categoriaProduto) {
        Optional<Leilao> leilao = leilaoRepository.findById(idLeilao);
        if(leilao.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Leilao não encontrado!");
        }
        switch (categoriaProduto){
            case VEICULO -> {
                return buscarProdutoVeiculo(leilao.get(),valorMinimo,valorMaximo,valorMinimoLance,valorMaximoLance,palavraChave);
            }
            case INFORMATICA -> {
                return buscarProdutoInformatica(leilao.get(),valorMinimo,valorMaximo,valorMinimoLance,valorMaximoLance,palavraChave);
            }
        }
        throw new SolicitacaoNaoEncontrada("Produto não encontrado!");
    }

    private Object buscarProdutoVeiculo(Leilao leilao, Double valorMinimo, Double valorMaximo, Double valorMinimoLance, Double valorMaximoLance,String palavraChave) {
        return produtoVeiculoRepository.buscarPorFiltros(leilao, valorMinimo,valorMaximo, valorMinimoLance,valorMaximoLance,palavraChave).stream().map(produtoVeiculo ->produtoVeiculo.criacaoDTO()).toList();
    }
    private Object buscarProdutoInformatica(Leilao leilao, Double valorMinimo, Double valorMaximo, Double valorMinimoLance, Double valorMaximoLance,String palavraChave) {

        return produtoInformaticaRepository.buscarPorFiltros(leilao, valorMinimo,valorMaximo, valorMinimoLance,valorMaximoLance,palavraChave).stream().map(produtoInformatica ->produtoInformatica.criacaoDTO()).toList();
    }

    public ResponseEntity<FileSystemResource> gerarArquivoDet(Long idLeilao) {
        Gson gson = new Gson();
        String conteudo = gson.toJson(consultarLeilaoPorId(idLeilao));
        try {
            String nomeArquivo = "exportacao-leilao-"+idLeilao+".det";

            File arquivo = new File(nomeArquivo);

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(conteudo);

            bw.close();

            FileSystemResource resource = new FileSystemResource(arquivo);

            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nomeArquivo);

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(arquivo.length())
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
}
