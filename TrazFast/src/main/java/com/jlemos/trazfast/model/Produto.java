package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLPRODUTOS")
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PROD_IDPRODUTO")
	private long idProduto;

	@Column(name="PROD_DESCRICAO")
	private String Descricao;

	@Column(name="PROD_DETALHES")
	private String Detalhes;

	@Column(name="PROD_IDFSUBCATEGORIA")
	private long idfSubCategoria;
	

	@Column(name="PROD_IMAGEM")
	private String Imagem;

	@Column(name="PROD_MARCA")
	private String Marca;

	@Column(name="PROD_UNIDADEDEMEDIDA")
	private String Unidadedemedida;

}