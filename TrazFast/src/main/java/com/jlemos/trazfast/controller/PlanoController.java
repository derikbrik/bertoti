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

import com.jlemos.trazfast.repository.PlanoRepository;

import com.jlemos.trazfast.model.Plano;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PlanoController {
    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping("/plano")
    public List < Plano > getAllPlano() {
        return planoRepository.findAll();
    }

    @GetMapping("/plano/{id}")
    public ResponseEntity < Plano > getPlanoById(@PathVariable(value = "id") Long planoId)
    throws ResourceNotFoundException {
        Plano plano = planoRepository.findById(planoId)
            .orElseThrow(() -> new ResourceNotFoundException("Plano nao encontrada para id :: " + planoId));
        return ResponseEntity.ok().body(plano);
    }

    @PostMapping("/plano")
    public Plano createPlano(@Valid @RequestBody Plano plano) {
        return planoRepository.save(plano);
    }

    @PutMapping("/plano/{id}")
    public ResponseEntity < Plano > updatePlano(@PathVariable(value = "id") Long planoId,
        @Valid @RequestBody Plano planoDetails) throws ResourceNotFoundException {
        Plano plano = planoRepository.findById(planoId)
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrada para id :: " + planoId));

        
        
        final Plano updatedPlano = planoRepository.save(plano);
        return ResponseEntity.ok(updatedPlano);
    }

    @DeleteMapping("/plano/{id}")
    public Map < String, Boolean > deletePlano(@PathVariable(value = "id") Long planoId)
    throws ResourceNotFoundException {
        Plano plano = planoRepository.findById(planoId)
            .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrada para id :: " + planoId));

        planoRepository.delete(plano);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}