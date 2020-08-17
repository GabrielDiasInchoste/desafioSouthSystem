package br.com.gabrielDias.desafioSouthSystem.services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.gabrielDias.desafioSouthSystem.dto.PautaDTO;
import br.com.gabrielDias.desafioSouthSystem.dto.PautaResultado;
import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;
import br.com.gabrielDias.desafioSouthSystem.repository.PautaRepository;
import br.com.gabrielDias.desafioSouthSystem.repository.VotoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PautaService {

	@Autowired
	private PautaRepository pautaRepository;
	
	@Autowired
	private VotoRepository votoRepository;

	public PautaEntity getPauta(Integer pautaId) throws Exception {

		log.info("PautaService.getPauta - start - pautaId: {}", pautaId);

		Optional<PautaEntity> pautaEntity = pautaRepository.findById(pautaId);
		if (pautaEntity.isPresent()) {
			log.info("PautaService.getPauta - end - pautaId: {}", pautaId);
			return pautaEntity.get();

		}else {
			log.error("PautaService.getPauta - Pauta nao encontrada - pautaId: {}", pautaId);
			throw new Exception("Pauta nao encontrada");
		}
	}

	public PautaEntity postPauta(PautaDTO pauta) {
		log.info("PautaService.postPauta - start - PautaDTO: {}", pauta);
		
		PautaEntity pautaEntity = new PautaEntity();
		pautaEntity.setNome(pauta.getNome());
		if(ObjectUtils.isEmpty(pauta.getTempo())) {
			pautaEntity.setTempo(ZonedDateTime.now().plusMinutes(1));
		}
		pautaRepository.save(pautaEntity);
		log.info("PautaService.postPauta - end - PautaEntity: {}", pautaEntity);

		return pautaEntity;
	}

	public PautaResultado getPautaResultado(Integer pautaId) throws Exception {
		PautaResultado pautaResultado = new PautaResultado(); 
		log.info("PautaService.getPautaResultado - start - pautaId: {}", pautaId);

		PautaEntity pauta = getPauta(pautaId);
		pautaResultado.setNome(pauta.getNome());
		pautaResultado.setTempo(pauta.getTempo());
		
		List<VotoEntity> listVoto = votoRepository.findByPautaId(pauta.getId());
		listVoto.stream().forEach(voto -> {
			if(voto.isVoto()) {
				pautaResultado.setVotosSim(pautaResultado.getVotosSim()+1);
			}else {
				pautaResultado.setVotosNao(pautaResultado.getVotosNao()+1);
			}
		});
		log.info("PautaService.getPautaResultado - end - pautaResultado: {}", pautaResultado);

		return pautaResultado;
	}

}
