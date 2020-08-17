package br.com.gabrielDias.desafioSouthSystem.services;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gabrielDias.desafioSouthSystem.dto.VotoDTO;
import br.com.gabrielDias.desafioSouthSystem.entity.AssociadoEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;
import br.com.gabrielDias.desafioSouthSystem.repository.AssociadoRepository;
import br.com.gabrielDias.desafioSouthSystem.repository.VotoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VotoService {

	@Autowired
	private VotoRepository votoRepository;
	
	@Autowired
	private AssociadoRepository associadoRepository;
	
	@Autowired
	private PautaService pautaService;
	
	public VotoEntity getVoto(Integer votoId) throws Exception {
		log.info("VotoService.getVoto - start - votoId: {}", votoId);

		Optional<VotoEntity> votoEntity = votoRepository.findById(votoId);
		if (votoEntity.isPresent()) {
			log.info("VotoService.getVoto - end - votoId: {}", votoId);
			return votoEntity.get();

		} else {
			log.error("VotoService.getVoto - Pauta nao encontrada - votoId: {}", votoId);
			throw new Exception("Voto nao encontrada");
		}
	}

	
	public VotoEntity votar(Integer pautaId,VotoDTO votoDTO) throws Exception {
		log.info("VotoService.iniciarVoto - start - pautaId: {}, votoDTO:{}",pautaId ,votoDTO);
		VotoEntity voto = new VotoEntity();
		
		AssociadoEntity associadoEntity = getAssociado(votoDTO); 
		PautaEntity pautaEntity = pautaService.getPauta(pautaId);
				
		validarVoto(pautaEntity, associadoEntity);
		
		voto.setAssociado(associadoEntity);
		voto.setPauta(pautaEntity);
		voto.setVoto(votoDTO.getVoto());
		votoRepository.save(voto);

		log.info("VotoService.iniciarVoto - end - pautaId: {}, votoDTO:{}",pautaId ,votoDTO);
		return voto;
		
	}

	private void validarVoto(PautaEntity pauta,AssociadoEntity associado) throws Exception {
		Optional<VotoEntity> voto = votoRepository.findByPautaIdAndAssociadoId(pauta.getId(),associado.getId());

		if (voto.isPresent()) {
			log.error("VotoService.iniciarVoto - Associado ja votou nessa pauta - pauta: {}", pauta);
			throw new Exception("Associado ja votou nessa pauta");
		}
		if(pauta.getTempo().isBefore(ZonedDateTime.now())) {
			log.error("VotoService.iniciarVoto - Votaçao encerrada - pauta: {}", pauta);
			throw new Exception("Votaçao encerrada");
		}
	}

	private AssociadoEntity getAssociado(VotoDTO votoDTO) {
		
		Optional<AssociadoEntity> associadoEntity = associadoRepository.findByCpf(votoDTO.getCpf());
		if(associadoEntity.isPresent()) {
			return associadoEntity.get();
		}else {
			
			AssociadoEntity associado = new AssociadoEntity();
			associado.setCpf(votoDTO.getCpf());
			associadoRepository.save(associado);
			return associado;
		}
	}

}
