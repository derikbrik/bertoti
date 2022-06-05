package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Segmento;

@Repository
public interface SegmentoRepository extends JpaRepository<Segmento,Long> {
	
} 
     