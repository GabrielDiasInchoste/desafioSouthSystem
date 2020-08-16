package br.com.gabrielDias.desafioSouthSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielDias.desafioSouthSystem.entity.PautaEntity;
import br.com.gabrielDias.desafioSouthSystem.services.PautaService;

@RestController
@RequestMapping("/v1/")
public class PautaController {

	@Autowired
	private PautaService PautaService;

	@GetMapping(value = "pauta/{pautaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PautaEntity> getPauta(@PathVariable(value = "pautaId") Integer pautaId) throws Exception {

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(PautaService.getPauta(pautaId));
	}
}
