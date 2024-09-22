package br.com.senac.api.useCases.parquesCientificos.repositorys;

import br.com.senac.api.entitys.CentrosInovacao;
import br.com.senac.api.entitys.ParquesCientificos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParquesCientificosRepositorys extends JpaRepository<ParquesCientificos, Long> {

}
