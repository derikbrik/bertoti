package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
	
} 
     