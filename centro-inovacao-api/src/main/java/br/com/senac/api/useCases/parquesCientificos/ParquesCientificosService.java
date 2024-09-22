package br.com.senac.api.useCases.parquesCientificos;

import br.com.senac.api.entitys.ParquesCientificos;
import br.com.senac.api.useCases.parquesCientificos.domains.ParquesCientificosRequestDom;
import br.com.senac.api.useCases.parquesCientificos.domains.ParquesCientificosResponseDom;
import br.com.senac.api.useCases.parquesCientificos.repositorys.ParquesCientificosRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParquesCientificosService {

    @Autowired
    private ParquesCientificosRepositorys parquesCientificosRepositorys;

    // Criar centro de inovação (aqui vão ficar as RN's)
    public ParquesCientificosResponseDom criarParquesCientificos(ParquesCientificosRequestDom parqueCientifico) throws Exception {

        // O que vai ser gravado no banco

        // Instanciando um objeto de movimentação
        ParquesCientificos parqueCientificoInsert = new ParquesCientificos();

        // Setando nome
        parqueCientificoInsert.setNome(parqueCientifico.getNome());

        // Setando cidade
        parqueCientificoInsert.setCidade(parqueCientifico.getCidade());

        // Setando estado
        parqueCientificoInsert.setEstado(parqueCientifico.getEstado());

        // Setando o endereço
        parqueCientificoInsert.setEndereco(parqueCientifico.getEndereco());

        // Setando o cep
        parqueCientificoInsert.setCep(parqueCientifico.getCep());

        // Setando a data
        parqueCientificoInsert.setData(parqueCientifico.getData());

        // Setando a descrição
        parqueCientificoInsert.setDescricao(parqueCientifico.getDescricao());

        // Setando o link
        parqueCientificoInsert.setLink(parqueCientifico.getLink());

        // Setando telefone
        parqueCientificoInsert.setTelefone(parqueCientifico.getTelefone());

        // Setando instituição financeira
        parqueCientificoInsert.setInstuicao_financeira(parqueCientifico.getInstituicao_financeira());

        // Salvando no BD
        ParquesCientificos resultado = parquesCientificosRepositorys.save(parqueCientificoInsert);

        // O que vai ser retornado pela API
        ParquesCientificosResponseDom response = new ParquesCientificosResponseDom();
        response.setId(resultado.getId());
        response.setNome(resultado.getNome());
        response.setEndereco(resultado.getEndereco());
        response.setCidade(resultado.getCidade());
        response.setEstado(resultado.getEstado());
        response.setCep(resultado.getCep());
        response.setData(resultado.getData());
        response.setDescricao(resultado.getDescricao());
        response.setLink(resultado.getLink());
        response.setTelefone(resultado.getTelefone());
        response.setInstituicao_financeira(resultado.getInstuicao_financeira());

        return response;

    }


    // Carregar todos parques cientificos
    public List<ParquesCientificosResponseDom> carregarParquesCientificos() {
        List<ParquesCientificos> resultado = parquesCientificosRepositorys.findAll();
        List<ParquesCientificosResponseDom> response = new ArrayList<>();

        for (ParquesCientificos parqueCientifico : resultado) {
            ParquesCientificosResponseDom parqueCientificoResponse = new ParquesCientificosResponseDom();
            parqueCientificoResponse.setId(parqueCientifico.getId());
            parqueCientificoResponse.setNome(parqueCientifico.getNome());
            parqueCientificoResponse.setEndereco(parqueCientifico.getEndereco());
            parqueCientificoResponse.setCidade(parqueCientifico.getCidade());
            parqueCientificoResponse.setEstado(parqueCientifico.getEstado());
            parqueCientificoResponse.setCep(parqueCientifico.getCep());
            parqueCientificoResponse.setData(parqueCientifico.getData());
            parqueCientificoResponse.setDescricao(parqueCientifico.getDescricao());
            parqueCientificoResponse.setLink(parqueCientifico.getLink());
            parqueCientificoResponse.setTelefone(parqueCientifico.getTelefone());
            parqueCientificoResponse.setInstituicao_financeira(parqueCientifico.getInstuicao_financeira());

            response.add(parqueCientificoResponse);
        }

        return response;

    }


    // Carregar parque específico
    public ParquesCientificos carregarParqueEspecifico(Long id) throws Exception {

        Optional<ParquesCientificos> resultado = parquesCientificosRepositorys.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new Exception("Parque não encontrado: " + id);
        }

    }


    // Excluir movimentação
    public boolean excluirParqueCientifico(Long id){
        parquesCientificosRepositorys.deleteById(id);
        return true;
    }

    // Atualizar parque cientifico
    public ParquesCientificosResponseDom atualizarParqueCientifico(Long cod, ParquesCientificosRequestDom parqueCientifico) throws Exception{

        // Atualiza produto passando o código do produto
        Optional<ParquesCientificos> resultado = parquesCientificosRepositorys.findById(cod).map(record -> {

            record.setNome(parqueCientifico.getNome());
            record.setEndereco(parqueCientifico.getEndereco());
            record.setCidade(parqueCientifico.getCidade());
            record.setEstado(parqueCientifico.getEstado());
            record.setCep(parqueCientifico.getCep());
            record.setData(parqueCientifico.getData());
            record.setDescricao(parqueCientifico.getDescricao());
            record.setLink(parqueCientifico.getLink());
            record.setTelefone(parqueCientifico.getTelefone());
            record.setInstuicao_financeira(parqueCientifico.getInstituicao_financeira());
            return parquesCientificosRepositorys.save(record);

        });

        if (resultado.isPresent()) {

            ParquesCientificos out = resultado.get();

            // O que vai retornar pela API
            ParquesCientificosResponseDom response = new ParquesCientificosResponseDom();
            response.setId(out.getId());
            response.setNome(out.getNome());
            response.setEndereco(out.getEndereco());
            response.setCidade(out.getCidade());
            response.setEstado(out.getEstado());
            response.setCep(out.getCep());
            response.setData(out.getData());
            response.setDescricao(out.getDescricao());
            response.setLink(out.getLink());
            response.setTelefone(out.getTelefone());
            response.setInstituicao_financeira(out.getInstuicao_financeira());

            return response;

        } else {

            throw new Exception("Agente " + cod + " não encontrado.");

        }
    }

}
