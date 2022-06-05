package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Horarioporregiao;

@Repository
public interface HorarioporregiaoRepository extends JpaRepository<Horarioporregiao,Long> {
	
} 
     