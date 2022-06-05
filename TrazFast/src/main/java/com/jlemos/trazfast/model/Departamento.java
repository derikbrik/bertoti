package com.jlemos.trazfast.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLDEPARTAMENTOS")
public class Departamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DPT_IDDEPARTAMENTO")
	private long idDepartamento;

	@Column(name="DPT_DEPARTAMENTO")
	private String Departamento;


	@Column(name="DPT_IDFSEGMENTO")
	private long idfSegmento;

}