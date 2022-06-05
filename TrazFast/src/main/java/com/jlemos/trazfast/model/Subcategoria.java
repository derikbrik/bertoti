package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLSUBCATEGORIAS")
public class Subcategoria{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SCT_IDSUBCATEGORIA")
	private long SubCategoriaId;

	@Column(name="SCT_SUBCATEGORIA")
	private String Subcategoria;

	@Column(name="SCT_IDFCATEGORIA")
	private Long idfCategoria;

	
}