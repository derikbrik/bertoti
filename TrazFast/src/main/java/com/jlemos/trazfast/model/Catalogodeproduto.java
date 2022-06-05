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
@Table(name="TBLCATALOGODEPRODUTOS")
public class Catalogodeproduto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CTP_IDCATALOGODEPRODUTO")
	private long Idcatalogodeproduto;

	@Column(name="CTP_IDFFORNECEDOR")
	private BigDecimal Idffornecedor;

	@Column(name="CTP_IDFPRODUTO")
	private BigDecimal Idfproduto;



}