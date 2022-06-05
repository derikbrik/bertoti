package com.jlemos.trazfast.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlemos.trazfast.repository.BancoRepository;

import com.jlemos.trazfast.model.Banco;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BancoController {
    @Autowired
    private BancoRepository bancoRepository;

    @GetMapping("/banco")
    public List < Banco > getAllBanco() {
        return bancoRepository.findAll();
    }

    @GetMapping("/banco/{id}")
    public ResponseEntity < Banco > getBancoById(@PathVariable(value = "id") Long bancoId)
    throws ResourceNotFoundException {
        Banco banco = bancoRepository.findById(bancoId)
            .orElseThrow(() -> new ResourceNotFoundException("Banco nao encontrado para id :: " + bancoId));
        return ResponseEntity.ok().body(banco);
    }

    @PostMapping("/banco")
    public Banco createBanco(@RequestBody Banco banco) {
    	
    	System.out.println(banco);
    	
        return bancoRepository.save(banco);
    }

    @PutMapping("/banco/{id}")
    public ResponseEntity < Banco > updateBanco(@PathVariable(value = "id") Long bancoId,
        @Valid @RequestBody Banco bancoDetails) throws ResourceNotFoundException {
        Banco banco = bancoRepository.findById(bancoId)
            .orElseThrow(() -> new ResourceNotFoundException("Banco não encontrado para id :: " + bancoId));

        
        
        final Banco updatedBanco = bancoRepository.save(banco);
        return ResponseEntity.ok(updatedBanco);
    }

    @DeleteMapping("/banco/{id}")
    public Map < String, Boolean > deleteBanco(@PathVariable(value = "id") Long bancoId)
    throws ResourceNotFoundException {
        Banco banco = bancoRepository.findById(bancoId)
            .orElseThrow(() -> new ResourceNotFoundException("Banco não encontrado para id :: " + bancoId));

        bancoRepository.delete(banco);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}