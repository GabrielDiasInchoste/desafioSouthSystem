package br.com.gabrielDias.desafioSouthSystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ASSOCIADO")
public class AssociadoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSOCIADO_ID_SEQ")
	@SequenceGenerator(name = "ASSOCIADO_ID_SEQ", sequenceName = "ASSOCIADO_ID_SEQ", allocationSize = 1)
	@Column(name = "ASSOCIADO_ID")
	private Integer id;

	@Column(name = "CPF")
	private Integer cpf;
	
}
