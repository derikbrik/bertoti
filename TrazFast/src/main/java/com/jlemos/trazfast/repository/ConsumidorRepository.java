package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Consumidor;

@Repository
public interface ConsumidorRepository extends JpaRepository<Consumidor,Long> {
	
} 
     