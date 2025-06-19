package br.com.senac.api.useCases.centrosInovacao.repositorys;

import br.com.senac.api.entitys.CentrosInovacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CentrosInovacaoRepository extends JpaRepository<CentrosInovacao, Long> {

}
