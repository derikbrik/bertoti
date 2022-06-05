package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLREGIOESDEATENDIMENTO")
public class Regiaodeatendimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RGA_IDREGIAODEATENDIMENTO")
	private long IdRegiaodeatendimento;

	@Column(name="RGA_IDFFORNECEDOR")
	private BigDecimal IdFornecedor;

	@Column(name="RGA_REGIAODEATENDIMENTO")
	private String Regiaodeatendimento;

	@Column(name="RGA_TAXADEENTREGA")
	private BigDecimal Taxadeentrega;

	@Column(name="RGA_IDFBAIRRO")
	private Long IdfBairro;


}