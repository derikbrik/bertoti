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
@Table(name="TBLPLANOS")
public class Plano {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLN_IDPLANO")
	private long Idplano;

	@Column(name="PLN_CONSUMOMINIMO")
	private BigDecimal Consumominimo;

	@Column(name="PLN_DESCONTO")
	private BigDecimal Desconto;

	@Column(name="PLN_HORARIOLIMITE")
	private Date Horariolimite;

	@Column(name="PLN_IDFFORNECEDOR")
	private BigDecimal Idffornecedor;

	@Column(name="PLN_LIMITEDIARIO")
	private BigDecimal Limitediario;

	@Column(name="PLN_PLANO")
	private String Plano;

	@Column(name="PLN_QUANTIDADEMINIMAMENSAL")
	private BigDecimal Quantidademinimamensal;

	@Column(name="PLN_UNIDADEDEMEDIDA")
	private String Unidadedemedida;

	@Column(name="PLN_IDFCATALOGODEPRODUTO")
	private Long idfCatalogodeproduto;

}