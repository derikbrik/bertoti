package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco,Long> {
	
} 
     