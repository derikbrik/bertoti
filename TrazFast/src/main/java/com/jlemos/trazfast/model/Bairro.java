package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLBAIRROS")
public class Bairro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BAI_IDBAIRRO")
	private long Idbairro;

	@Column(name="BAI_BAIRRO")
	private String Bairro;

	@Column(name="BAI_IDFCIDADE")
	private long idfcidade;


}