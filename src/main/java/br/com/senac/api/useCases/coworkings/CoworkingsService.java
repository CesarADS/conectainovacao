package br.com.senac.api.useCases.coworkings;

import java.util.*;

import br.com.senac.api.entitys.CentrosInovacao;
import br.com.senac.api.entitys.Coworkings;
import br.com.senac.api.useCases.coworkings.domains.CoworkingsRequestDom;
import br.com.senac.api.useCases.coworkings.domains.CoworkingsResponseDom;
import br.com.senac.api.useCases.coworkings.repositorys.CoworkingsRepositorys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class CoworkingsService {

    @Autowired
    private CoworkingsRepositorys coworkingsRepository;

    // Criar centro de inovação (aqui vão ficar as RN's)
    public CoworkingsResponseDom criarCoworking(CoworkingsRequestDom coworking) throws Exception {

        // O que vai ser gravado no banco

        // Instanciando um objeto de Centro de Inovação
        Coworkings coworkingInsert = new Coworkings();

        // Setando nome
        coworkingInsert.setNome(coworking.getNome());

        // Setando cidade
        coworkingInsert.setCidade(coworking.getCidade());

        // Setando estado
        coworkingInsert.setEstado(coworking.getEstado());

        // Setando o endereço
        coworkingInsert.setEndereco(coworking.getEndereco());

        // Setando o cep
        coworkingInsert.setCep(coworking.getCep());

        // Setando a data
        coworkingInsert.setData(coworking.getData());

        // Setando a descrição
        coworkingInsert.setDescricao(coworking.getDescricao());

        // Setando o link
        coworkingInsert.setLink(coworking.getLink());

        // Setando telefone
        coworkingInsert.setTelefone(coworking.getTelefone());

        // Setando horário de funcionamento
        coworkingInsert.setHorario_funcionamento(coworking.getHorario_funcionamento());

        // Salvando no BD
        Coworkings resultado = coworkingsRepository.save(coworkingInsert);

        // O que vai ser retornado pela API
        CoworkingsResponseDom response = new CoworkingsResponseDom();
        response.setId(resultado.getId());
        response.setNome(resultado.getNome());
        response.setCidade(resultado.getCidade());
        response.setEstado(resultado.getEstado());
        response.setEndereco(resultado.getEndereco());
        response.setCep(resultado.getCep());
        response.setData(resultado.getData());
        response.setDescricao(resultado.getDescricao());
        response.setLink(resultado.getLink());
        response.setTelefone(resultado.getTelefone());
        response.setHorario_funcionamento(coworking.getHorario_funcionamento());

        return response;

    }


    // Carregar coworking específico
    public Coworkings carregarCoworking(Long id) throws Exception {

        Optional<Coworkings> resultado = coworkingsRepository.findById(id);

        if (resultado.isPresent()) {
            return resultado.get();
        } else {
            throw new Exception("Centro não encontrado: " + id);
        }

    }


    // Atualizar parque cientifico
    public CoworkingsResponseDom atualizarCoworking(Long cod, CoworkingsRequestDom coworking) throws Exception{

        // Atualiza produto passando o código do produto
        Optional<Coworkings> resultado = coworkingsRepository.findById(cod).map(record -> {

            record.setNome(coworking.getNome());
            record.setEndereco(coworking.getEndereco());
            record.setCidade(coworking.getCidade());
            record.setEstado(coworking.getEstado());
            record.setCep(coworking.getCep());
            record.setData(coworking.getData());
            record.setDescricao(coworking.getDescricao());
            record.setLink(coworking.getLink());
            record.setTelefone(coworking.getTelefone());
            record.setHorario_funcionamento(coworking.getHorario_funcionamento());
            return coworkingsRepository.save(record);

        });

        if (resultado.isPresent()) {

            Coworkings out = resultado.get();

            // O que vai retornar pela API
            CoworkingsResponseDom response = new CoworkingsResponseDom();
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
            response.setHorario_funcionamento(out.getHorario_funcionamento());

            return response;

        } else {

            throw new Exception("Agente " + cod + " não encontrado.");

        }
    }


    // Carregar todos centros de inovação
    public List<CoworkingsResponseDom> carregarCoworkings() {
        List<Coworkings> resultado = coworkingsRepository.findAll();
        List<CoworkingsResponseDom> response = new ArrayList<>();

        for (Coworkings coworking : resultado) {
            CoworkingsResponseDom coworkingResponse = new CoworkingsResponseDom();
            coworkingResponse.setId(coworking.getId());
            coworkingResponse.setNome(coworking.getNome());
            coworkingResponse.setEndereco(coworking.getEndereco());
            coworkingResponse.setCidade(coworking.getCidade());
            coworkingResponse.setEstado(coworking.getEstado());
            coworkingResponse.setCep(coworking.getCep());
            coworkingResponse.setData(coworking.getData());
            coworkingResponse.setDescricao(coworking.getDescricao());
            coworkingResponse.setLink(coworking.getLink());
            coworkingResponse.setTelefone(coworking.getTelefone());
            coworkingResponse.setHorario_funcionamento(coworking.getHorario_funcionamento());

            response.add(coworkingResponse);
        }

        return response;

    }


    // Excluir movimentação
    public boolean excluirCoworking(Long id){
        coworkingsRepository.deleteById(id);
        return true;
    }




}


