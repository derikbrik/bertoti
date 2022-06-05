package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Catalogodeproduto;

@Repository
public interface CatalogodeprodutoRepository extends JpaRepository<Catalogodeproduto,Long> {
	
} 
     