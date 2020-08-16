package br.com.gabrielDias.desafioSouthSystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.repository.PautaRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;

	public PautaEntity getPauta(Integer pautaId) {

		log.info("PautaService.getPauta - start - pautaId: {}", pautaId);

		Optional<PautaEntity> pautaEntity = pautaRepository.findById(pautaId);

		log.info("PautaService.getPauta - end - pautaId: {}", pautaId);

		return pautaEntity.get();
	}

}
