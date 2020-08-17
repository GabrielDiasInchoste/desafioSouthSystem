package br.com.gabrielDias.desafioSouthSystem.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class PautaDTO {

	@NotBlank
	private String nome;
	
	private ZonedDateTime tempo;

	
}
