package br.com.gabrielDias.desafioSouthSystem.dto;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PautaResultado {

	private String nome;
	
	private ZonedDateTime tempo;
	
	private int votosSim;

	private int votosNao;

	
}
