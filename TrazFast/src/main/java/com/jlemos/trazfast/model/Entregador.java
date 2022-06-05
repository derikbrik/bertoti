package com.jlemos.trazfast.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLENTREGADORES")
public class Entregador  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ENT_IDENTREGADOR")
	private long IdEntregador;

	@Column(name="ENT_CPF")
	private String Cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="ENT_DATANASCIMENTO")
	private Date Datanascimento;

	
	@Column(name="ENT_FOTO")
	private String Foto;

	@Column(name="ENT_NOME")
	private String Nome;

	@Column(name="ENT_RG")
	private String Rg;

	@Column(name="ENT_SOBRENOME")
	private String Sobrenome;

	@Column(name="ENT_IDFUSUARIO")
	private long idfusuario;


}