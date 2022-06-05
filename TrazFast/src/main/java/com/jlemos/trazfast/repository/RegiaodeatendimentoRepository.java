package com.jlemos.trazfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlemos.trazfast.model.Regiaodeatendimento;

@Repository
public interface RegiaodeatendimentoRepository extends JpaRepository<Regiaodeatendimento,Long> {
	
} 
     