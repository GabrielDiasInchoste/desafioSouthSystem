package br.com.gabrielDias.desafioSouthSystem.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

	@NotBlank
	private Integer cpf;
	
	@NotBlank
	private Boolean voto;
	
}
