package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Subcategoria;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria,Long> {
	
} 
     