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
@Table(name="TBLBANCOS")
public class Banco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BAN_IDBANCO")
	private Long Idbanco;

	@Column(name="BAN_BANCO")
	private String Banco;

	@Column(name="BAN_CODIGO")
	private BigDecimal Codigo;


}