package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Horariodeentrega;

@Repository
public interface HorariodeentregaRepository extends JpaRepository<Horariodeentrega,Long> {
	
} 
     