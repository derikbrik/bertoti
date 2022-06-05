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
@Table(name="TBLUSUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USR_IDUSUARIO")
	private long Idusuario;

	@Column(name="USR_EMAIL")
	private String Email;

	@Column(name="USR_IDTIPO")
	private BigDecimal Idtipo;

	@Column(name="USR_PASSWORD")
	private String Password;

	@Column(name="USR_PROVIDERID")
	private String Providerid;

	@Column(name="USR_USUARIO")
	private String Usuario;



}