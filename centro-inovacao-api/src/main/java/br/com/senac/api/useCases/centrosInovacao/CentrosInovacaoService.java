package br.com.senac.api.useCases.centrosInovacao;

import java.util.*;

import br.com.senac.api.entitys.CentrosInovacao;
import br.com.senac.api.entitys.ParquesCientificos;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoRequestDom;
import br.com.senac.api.useCases.centrosInovacao.domains.CentrosInovacaoResponseDom;
import br.com.senac.api.useCases.centrosInovacao.repositorys.CentrosInovacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CentrosInovacaoService {

    @Autowired
    private CentrosInovacaoRepository centrosInovacaoRepository;


    // Criar centro de inovação (aqui vão ficar as RN's)
    public CentrosInovacaoResponseDom criarCentroInovacao(CentrosInovacaoRequestDom centroInovacao) throws Exception {

        // O que vai ser gravado no banco

        // Instanciando um objeto de Centro de Inovação
        CentrosInovacao centroInovacaoInsert = new CentrosInovacao();

        // Setando nome
        centroInovacaoInsert.setNome(centroInovacao.getNome());

        // Setando cidade
        centroInovacaoInsert.setCidade(centroInovacao.getCidade());

        // Setando estado
        centroInovacaoInsert.setEstado(centroInovacao.getEstado());

        // Setando o endereço
        centroInovacaoInsert.setEndereco(centroInovacao.getEndereco());

        // Setando o cep
        centroInovacaoInsert.setCep(centroInovacao.getCep());

        // Setando a data
        centroInovacaoInsert.setData(centroInovacao.getData());

        // Setando a descrição
        centroInovacaoInsert.setDescricao(centroInovacao.getDescricao());

        // Setando o link
        centroInovacaoInsert.setLink(centroInovacao.getLink());

        // Setando telefone
        centroInovacaoInsert.setTelefone(centroInovacao.getTelefone());

        // Salvando no BD
        CentrosInovacao resultado = centrosInovacaoRepository.save(centroInovacaoInsert);

        // O que vai ser retornado pela API
        CentrosInovacaoResponseDom response = new CentrosInovacaoResponseDom();
        response.setId(resultado.getId());
        response.setCidade(resultado.getCidade());
        response.setEstado(resultado.getEstado());
        response.setEndereco(resultado.getEndereco());
        response.setNome(resultado.getNome());
        response.setCep(resultado.getCep());
        response.setData(resultado.getData());
        response.setDescricao(resultado.getDescricao());
        response.setLink(resultado.getLink());
        response.setTelefone(resultado.getTelefone());

        return response;

    }


    // Carregar centro específico
    public CentrosInovacao carregarCentroInovacao(Long id) throws Exception {

        Optional<CentrosInovacao> resultado = centrosInovacaoRepository.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new Exception("Centro não encontrado: " + id);
        }

    }



    // Atualizar parque cientifico
    public CentrosInovacaoResponseDom atualizarCentroInovacao(Long cod, CentrosInovacaoRequestDom centroInovacao) throws Exception{

        // Atualiza produto passando o código do produto
        Optional<CentrosInovacao> resultado = centrosInovacaoRepository.findById(cod).map(record -> {

            record.setNome(centroInovacao.getNome());
            record.setCidade(centroInovacao.getCidade());
            record.setEstado(centroInovacao.getEstado());
            record.setEndereco(centroInovacao.getEndereco());
            record.setCep(centroInovacao.getCep());
            record.setData(centroInovacao.getData());
            record.setDescricao(centroInovacao.getDescricao());
            record.setLink(centroInovacao.getLink());
            record.setTelefone(centroInovacao.getTelefone());
            return centrosInovacaoRepository.save(record);

        });

        if (resultado.isPresent()) {

            CentrosInovacao out = resultado.get();

            // O que vai retornar pela API
            CentrosInovacaoResponseDom response = new CentrosInovacaoResponseDom();
            response.setId(out.getId());
            response.setNome(out.getNome());
            response.setCidade(out.getCidade());
            response.setEstado(out.getEstado());
            response.setEndereco(out.getEndereco());
            response.setCep(out.getCep());
            response.setData(out.getData());
            response.setDescricao(out.getDescricao());
            response.setLink(out.getLink());
            response.setTelefone(out.getTelefone());

            return response;

        } else {

            throw new Exception("Agente " + cod + " não encontrado.");

        }
    }


    // Carregar todos centros de inovação
    public List<CentrosInovacaoResponseDom> carregarCentrosInovacao() {
        List<CentrosInovacao> resultado = centrosInovacaoRepository.findAll();
        List<CentrosInovacaoResponseDom> response = new ArrayList<>();

        for (CentrosInovacao centroInovacao : resultado) {
            CentrosInovacaoResponseDom centroInovacaoResponse = new CentrosInovacaoResponseDom();
            centroInovacaoResponse.setId(centroInovacao.getId());
            centroInovacaoResponse.setNome(centroInovacao.getNome());
            centroInovacaoResponse.setCidade(centroInovacao.getCidade());
            centroInovacaoResponse.setEstado(centroInovacao.getEstado());
            centroInovacaoResponse.setEndereco(centroInovacao.getEndereco());
            centroInovacaoResponse.setCep(centroInovacao.getCep());
            centroInovacaoResponse.setData(centroInovacao.getData());
            centroInovacaoResponse.setDescricao(centroInovacao.getDescricao());
            centroInovacaoResponse.setLink(centroInovacao.getLink());
            centroInovacaoResponse.setTelefone(centroInovacao.getTelefone());

            response.add(centroInovacaoResponse);
        }

        return response;

    }


    // Excluir movimentação
    public boolean excluirCentroInovacao(Long id){
        centrosInovacaoRepository.deleteById(id);
        return true;
    }




}


