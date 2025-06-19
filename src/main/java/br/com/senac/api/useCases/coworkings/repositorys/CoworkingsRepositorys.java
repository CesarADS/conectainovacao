package br.com.senac.api.useCases.coworkings.repositorys;

import br.com.senac.api.entitys.CentrosInovacao;
import br.com.senac.api.entitys.Coworkings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoworkingsRepositorys extends JpaRepository<Coworkings, Long> {

}
