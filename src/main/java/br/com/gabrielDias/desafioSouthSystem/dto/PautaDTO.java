package br.com.gabrielDias.desafioSouthSystem.dto;

import java.time.ZonedDateTime;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

	@NotBlank
	private String nome;
	
	private ZonedDateTime tempo;

	
}
