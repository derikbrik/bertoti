package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro,Long> {
	
} 
     