package com.jlemos.trazfast.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLCIDADES")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CID_IDCIDADE")
	private long Idcidade;

	@Column(name="CID_CIDADE")
	private String Cidade;

	@Column(name="CID_UF")
	private String idfUf;



}