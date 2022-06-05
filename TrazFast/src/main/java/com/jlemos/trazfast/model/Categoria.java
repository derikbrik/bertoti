package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLCATEGORIAS")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="CAT_IDCATEGORIA")
	private Long IdCategoria;

	@Column(name="CAT_CATEGORIA")
	private String Categoria;


	@Column(name="CAT_IDFDEPARTAMENTO")
	private Long IdfDepartamento;
	
	
	
}