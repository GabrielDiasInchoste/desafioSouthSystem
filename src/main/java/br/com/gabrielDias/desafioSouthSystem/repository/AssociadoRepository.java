package br.com.gabrielDias.desafioSouthSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrielDias.desafioSouthSystem.entity.AssociadoEntity;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Integer>{

	Optional<AssociadoEntity> findByCpf(Integer cpf);

}
