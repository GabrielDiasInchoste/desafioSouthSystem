package br.com.gabrielDias.desafioSouthSystem.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VOTO")
public class VotoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOTO_ID_SEQ")
	@SequenceGenerator(name = "VOTO_ID_SEQ", sequenceName = "VOTO_ID_SEQ", allocationSize = 1)
	@Column(name = "VOTO_ID")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PAUTA_ID")
	private PautaEntity pauta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSOCIADO_ID",nullable = true)
	private AssociadoEntity associado;

	@Column(name = "VOTO")
	private boolean voto;
	
}
