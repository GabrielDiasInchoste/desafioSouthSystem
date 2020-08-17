package br.com.gabrielDias.desafioSouthSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Integer>{

	Optional<VotoEntity> findByPautaIdAndAssociadoId(Integer pautaId, Integer associadoId);

	List<VotoEntity> findByPautaId(Integer pautaId);

}
