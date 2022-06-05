package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long> {
	
} 
     