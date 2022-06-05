package com.jlemos.trazfast.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLASSINATURAS")
public class Assinatura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ASS_IDASSINATURA")
	private long Idassinatura;

	
	@Column(name="ASS_IDFCONSUMIDOR")
	private long idfconsumidor;

	@Column(name="ASS_IDFHORARIOPORREGIAO")
	private long idfhorarioporregiao;

	@Column(name="ASS_IDFPLANO")
	private long  idfplano;
	
}