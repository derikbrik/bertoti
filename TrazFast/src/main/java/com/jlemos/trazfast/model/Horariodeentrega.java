package com.jlemos.trazfast.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLHORARIOSDEENTREGA")
public class Horariodeentrega{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HDE_IDHORARIODEENTREGA")
	private long Idhorariodeentrega;

	@Column(name="HDE_DIADASEMANA")
	private BigDecimal Diadasemana;

	@Column(name="HDE_HORARIO")
	private Date Horario;

	@Column(name="HDE_IDFPLANO")
	private Long idf_Plano;

	

}