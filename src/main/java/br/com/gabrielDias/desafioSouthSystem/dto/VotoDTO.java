package br.com.gabrielDias.desafioSouthSystem.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class VotoDTO {

	@NotBlank
	private Integer cpf;
	
	@NotBlank
	private Boolean voto;
	
}
