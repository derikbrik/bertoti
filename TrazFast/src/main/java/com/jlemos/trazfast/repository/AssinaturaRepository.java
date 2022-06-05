package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Assinatura;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura,Long> {
	
} 
     