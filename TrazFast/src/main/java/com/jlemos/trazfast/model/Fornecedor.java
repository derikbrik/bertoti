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
@Table(name="TBLFORNECEDORES")
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FRN_IDFORNECEDOR")
	private Long idFornecedor;

	@Column(name="FRN_AGENCIA")
	private BigDecimal Agencia;

	@Column(name="FRN_BAIRRO")
	private String Bairro;

	@Column(name="FRN_CEP")
	private String Cep;

	@Column(name="FRN_CIDADE")
	private String Cidade;

	@Column(name="FRN_CNPJ")
	private String Cnpj;

	@Column(name="FRN_CONTA")
	private BigDecimal Conta;

	@Column(name="FRN_EMAIL")
	private String Email;

	@Column(name="FRN_ENDERECO")
	private String Endereco;

	@Column(name="FRN_ESTADO")
	private String Estado;

	@Column(name="FRN_EXPEDIENTEFINAL")
	private Date Expedientefinal;

	
	@Column(name="FRN_EXPEDIENTEINICIO")
	private Date Expedienteinicio;

	@Column(name="FRN_INSCRICAOESTADUAL")
	private String Inscricaoestadual;

	@Column(name="FRN_LATITUDE")
	private double Latitude;

	@Column(name="FRN_LONGITUDE")
	private double Longitude;

	@Column(name="FRN_NOMEFANTASIA")
	private String Nomefantasia;

	@Column(name="FRN_NUMERO")
	private String Numero;

	@Column(name="FRN_RAZAOSOCIAL")
	private String Razaosocial;

	@Column(name="FRN_TELEFONECELULAR")
	private String Telefonecelular;

	@Column(name="FRN_TELEFONECOMERCIAL")
	private String Telefonecomercial;

	@Column(name="FRN_IDFBANCO")
	private long idfBanco;

	@Column(name="FRN_IDFUSUARIO")
	private long idfUsuario;

	

}