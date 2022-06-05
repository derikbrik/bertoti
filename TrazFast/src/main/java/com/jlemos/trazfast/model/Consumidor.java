package com.jlemos.trazfast.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLCONSUMIDORES")
public class Consumidor{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CSM_IDCONSUMIDOR")
	private long IdConsumidor;

	@Column(name="CSM_BAIRRO")
	private String Bairro;

	@Column(name="CSM_BAIRROENTREGA")
	private String Bairroentrega;

	@Column(name="CSM_CEP")
	private String Cep;

	@Column(name="CSM_CEPENTREGA")
	private String Cepentrega;

	@Column(name="CSM_CIDADE")
	private String Cidade;

	@Column(name="CSM_CIDADEENTREGA")
	private String Cidadeentrega;

	@Column(name="CSM_COMPLEMENTO")
	private String Complemento;

	@Column(name="CSM_COMPLEMENTOENTREGA")
	private String Complementoentrega;

	@Column(name="CSM_CPF")
	private BigDecimal Cpf;

	@Column(name="CSM_ENDERECO")
	private String Endereco;

	@Column(name="CSM_ENDERECOENTREGA")
	private String Enderecoentrega;

	@Column(name="CSM_NOME")
	private String Nome;

	@Column(name="CSM_RG")
	private BigDecimal Rg;

	@Column(name="CSM_UF")
	private String Uf;

	@Column(name="CSM_UFENTREGA")
	private String UfEntrega;

	@Column(name="CSM_IDFUSUARIO")
	private long idfusuario;


}