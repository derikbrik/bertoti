package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Tipodeusuario;

@Repository
public interface TipodeusuarioRepository extends JpaRepository<Tipodeusuario,Long> {
	
} 
     