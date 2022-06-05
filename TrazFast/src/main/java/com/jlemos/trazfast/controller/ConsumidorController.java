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

import com.jlemos.trazfast.repository.ConsumidorRepository;

import com.jlemos.trazfast.model.Consumidor;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ConsumidorController {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    @GetMapping("/consumidor")
    public List < Consumidor > getAllConsumidor() {
        return consumidorRepository.findAll();
    }

    @GetMapping("/consumidor/{id}")
    public ResponseEntity < Consumidor > getConsumidorById(@PathVariable(value = "id") Long consumidorId)
    throws ResourceNotFoundException {
        Consumidor consumidor = consumidorRepository.findById(consumidorId)
            .orElseThrow(() -> new ResourceNotFoundException("Consumidor nao encontrada para id :: " + consumidorId));
        return ResponseEntity.ok().body(consumidor);
    }

    @PostMapping("/consumidor")
    public Consumidor createConsumidor(@Valid @RequestBody Consumidor consumidor) {
        return consumidorRepository.save(consumidor);
    }

    @PutMapping("/consumidor/{id}")
    public ResponseEntity < Consumidor > updateConsumidor(@PathVariable(value = "id") Long consumidorId,
        @Valid @RequestBody Consumidor consumidorDetails) throws ResourceNotFoundException {
        Consumidor consumidor = consumidorRepository.findById(consumidorId)
            .orElseThrow(() -> new ResourceNotFoundException("Consumidor não encontrada para id :: " + consumidorId));

        
        
        final Consumidor updatedConsumidor = consumidorRepository.save(consumidor);
        return ResponseEntity.ok(updatedConsumidor);
    }

    @DeleteMapping("/consumidor/{id}")
    public Map < String, Boolean > deleteConsumidor(@PathVariable(value = "id") Long consumidorId)
    throws ResourceNotFoundException {
        Consumidor consumidor = consumidorRepository.findById(consumidorId)
            .orElseThrow(() -> new ResourceNotFoundException("Consumidor não encontrada para id :: " + consumidorId));

        consumidorRepository.delete(consumidor);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}