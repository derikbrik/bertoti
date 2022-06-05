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

import com.jlemos.trazfast.repository.EntregadorRepository;

import com.jlemos.trazfast.model.Entregador;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EntregadorController {
    @Autowired
    private EntregadorRepository entregadorRepository;

    @GetMapping("/entregador")
    public List < Entregador > getAllEntregador() {
        return entregadorRepository.findAll();
    }

    @GetMapping("/entregador/{id}")
    public ResponseEntity < Entregador > getEntregadorById(@PathVariable(value = "id") Long entregadorId)
    throws ResourceNotFoundException {
        Entregador entregador = entregadorRepository.findById(entregadorId)
            .orElseThrow(() -> new ResourceNotFoundException("Entregador nao encontrada para id :: " + entregadorId));
        return ResponseEntity.ok().body(entregador);
    }

    @PostMapping("/entregador")
    public Entregador createEntregador(@Valid @RequestBody Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    @PutMapping("/entregador/{id}")
    public ResponseEntity < Entregador > updateEntregador(@PathVariable(value = "id") Long entregadorId,
        @Valid @RequestBody Entregador entregadorDetails) throws ResourceNotFoundException {
        Entregador entregador = entregadorRepository.findById(entregadorId)
            .orElseThrow(() -> new ResourceNotFoundException("Entregador não encontrada para id :: " + entregadorId));

        
        
        final Entregador updatedEntregador = entregadorRepository.save(entregador);
        return ResponseEntity.ok(updatedEntregador);
    }

    @DeleteMapping("/entregador/{id}")
    public Map < String, Boolean > deleteEntregador(@PathVariable(value = "id") Long entregadorId)
    throws ResourceNotFoundException {
        Entregador entregador = entregadorRepository.findById(entregadorId)
            .orElseThrow(() -> new ResourceNotFoundException("Entregador não encontrada para id :: " + entregadorId));

        entregadorRepository.delete(entregador);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}