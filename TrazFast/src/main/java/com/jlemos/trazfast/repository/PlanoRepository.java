package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano,Long> {
	
} 
     