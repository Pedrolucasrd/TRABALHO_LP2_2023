package com.lp2.leilao.service;


import com.lp2.leilao.exception.SolicitacaoNaoEncontrada;
import com.lp2.leilao.model.Cliente;
import com.lp2.leilao.model.LanceProdutoInformatica;
import com.lp2.leilao.model.LanceProdutoVeiculo;
import com.lp2.leilao.model.dto.cliente.AtualizaClienteDTO;
import com.lp2.leilao.model.dto.cliente.CadastroClienteDTO;
import com.lp2.leilao.model.dto.cliente.ExibicaoClienteDTO;
import com.lp2.leilao.model.dto.cliente.ExibicaoListagemClientesDTO;
import com.lp2.leilao.model.dto.lance.ExibicaoLanceProdutoDTO;
import com.lp2.leilao.repository.ClienteRepository;
import com.lp2.leilao.repository.LanceProdutoInformaticaRepository;
import com.lp2.leilao.repository.LanceProdutoVeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        return new ExibicaoClienteDTO(cliente.get());
    }

    public List<ExibicaoListagemClientesDTO> listarTodosClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes.stream()
                .map(ExibicaoListagemClientesDTO::new).toList();
    }

    public ExibicaoClienteDTO atualizarCliente(String cpf, AtualizaClienteDTO atualizaClienteDTO) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(cpf);
        if(clienteEncontrado.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        Cliente clienteAtualizado = new Cliente(clienteEncontrado.get(), atualizaClienteDTO);
        clienteRepository.save(clienteAtualizado);
        return new ExibicaoClienteDTO(clienteAtualizado);
    }

    public List<ExibicaoLanceProdutoDTO> procurarLancesPorCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findById(cpf);
        if(cliente.isEmpty()){
            throw new SolicitacaoNaoEncontrada("Cliente não encontrado!");
        }
        List<LanceProdutoInformatica> listaLancesInfo = lanceProdutoInformaticaRepository.findAllByCliente(cliente.get());
        List<LanceProdutoVeiculo> listaLancesVei = lanceProdutoVeiculoRepository.findAllByCliente(cliente.get());
        List<ExibicaoLanceProdutoDTO> exibicaoLanceProdutoDTO1 = listaLancesInfo.stream().map(ExibicaoLanceProdutoDTO::new).toList();
        List<ExibicaoLanceProdutoDTO> exibicaoLanceProdutoDTO2 = listaLancesVei.stream().map(ExibicaoLanceProdutoDTO::new).toList();
        List<ExibicaoLanceProdutoDTO> listaConcatenada = new ArrayList<>();
        listaConcatenada.addAll(exibicaoLanceProdutoDTO1);
        listaConcatenada.addAll(exibicaoLanceProdutoDTO2);
        return listaConcatenada;
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
