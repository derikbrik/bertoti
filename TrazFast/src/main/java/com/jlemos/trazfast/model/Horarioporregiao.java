package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLHORARIOSPORREGIAO")
public class Horarioporregiao {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="HPR_IDHORARIOPORREGIAO")
	private long Idhorarioporregiao;

	@Column(name="HPR_DIADASEMANA")
	private BigDecimal Diadasemana;

	@Column(name="HPR_HORARIO")
	private Date Horario;


	@Column(name="HPR_IDFREGIAODEATENDIMENTO")
	private Long idfRegiaodeatendimento;


}