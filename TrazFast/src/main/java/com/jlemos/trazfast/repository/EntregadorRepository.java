package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Entregador;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador,Long> {
	
} 
     