package br.com.gabrielDias.desafioSouthSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielDias.desafioSouthSystem.dto.PautaDTO;
import br.com.gabrielDias.desafioSouthSystem.dto.PautaResultado;
import br.com.gabrielDias.desafioSouthSystem.dto.VotoDTO;
import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.entity.VotoEntity;
import br.com.gabrielDias.desafioSouthSystem.services.PautaService;
import br.com.gabrielDias.desafioSouthSystem.services.VotoService;

@RestController
@RequestMapping("/v1/")
public class PautaController {

	@Autowired
	private PautaService pautaService;
	
	@Autowired
	private VotoService votoService;

	@GetMapping(value = "pauta/{pautaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PautaEntity> getPauta(@PathVariable(value = "pautaId") Integer pautaId) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(pautaService.getPauta(pautaId));
	}
	
	@GetMapping(value = "pauta/{pautaId}/resultado", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PautaResultado> getPautaResultado(@PathVariable(value = "pautaId") Integer pautaId) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(pautaService.getPautaResultado(pautaId));
	}
	
	@PostMapping(value = "pauta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PautaEntity> postPauta(@RequestBody PautaDTO pauta) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(pautaService.postPauta(pauta));
	}
	
	@PostMapping(value = "pauta/{pautaId}/votar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VotoEntity> iniciarSessao(@PathVariable(value = "pautaId") Integer pautaId,@RequestBody VotoDTO votoDTO) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(votoService.votar(pautaId,votoDTO));
	}
	
}
