package com.jlemos.trazfast.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBLSEGMENTOS")

public class Segmento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SGM_IDSEGMENTO")
	private long Idsegmento;

	@Column(name="SGM_SEGMENTO")
	private String Segmento;

}