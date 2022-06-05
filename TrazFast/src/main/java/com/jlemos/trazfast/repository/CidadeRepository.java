package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {
	
} 
     