package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLTIPOSDEUSUARIOS")
public class Tipodeusuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TIU_IDTIPODEUSUARIO")
	private long IdTipodeusuario;

	@Column(name="TIU_TIPODEUSUARIO")
	private String Tipodeusuario;


}