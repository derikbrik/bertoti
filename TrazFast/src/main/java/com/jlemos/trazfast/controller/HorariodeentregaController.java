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

import com.jlemos.trazfast.repository.HorariodeentregaRepository;

import com.jlemos.trazfast.model.Horariodeentrega;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class HorariodeentregaController {
    @Autowired
    private HorariodeentregaRepository horariodeentregaRepository;

    @GetMapping("/horariodeentrega")
    public List < Horariodeentrega > getAllHorariodeentrega() {
        return horariodeentregaRepository.findAll();
    }

    @GetMapping("/horariodeentrega/{id}")
    public ResponseEntity < Horariodeentrega > getHorariodeentregaById(@PathVariable(value = "id") Long horariodeentregaId)
    throws ResourceNotFoundException {
        Horariodeentrega horariodeentrega = horariodeentregaRepository.findById(horariodeentregaId)
            .orElseThrow(() -> new ResourceNotFoundException("Horariodeentrega nao encontrada para id :: " + horariodeentregaId));
        return ResponseEntity.ok().body(horariodeentrega);
    }

    @PostMapping("/horariodeentrega")
    public Horariodeentrega createHorariodeentrega(@Valid @RequestBody Horariodeentrega horariodeentrega) {
        return horariodeentregaRepository.save(horariodeentrega);
    }

    @PutMapping("/horariodeentrega/{id}")
    public ResponseEntity < Horariodeentrega > updateHorariodeentrega(@PathVariable(value = "id") Long horariodeentregaId,
        @Valid @RequestBody Horariodeentrega horariodeentregaDetails) throws ResourceNotFoundException {
        Horariodeentrega horariodeentrega = horariodeentregaRepository.findById(horariodeentregaId)
            .orElseThrow(() -> new ResourceNotFoundException("Horariodeentrega não encontrada para id :: " + horariodeentregaId));

        
        
        final Horariodeentrega updatedHorariodeentrega = horariodeentregaRepository.save(horariodeentrega);
        return ResponseEntity.ok(updatedHorariodeentrega);
    }

    @DeleteMapping("/horariodeentrega/{id}")
    public Map < String, Boolean > deleteHorariodeentrega(@PathVariable(value = "id") Long horariodeentregaId)
    throws ResourceNotFoundException {
        Horariodeentrega horariodeentrega = horariodeentregaRepository.findById(horariodeentregaId)
            .orElseThrow(() -> new ResourceNotFoundException("Horariodeentrega não encontrada para id :: " + horariodeentregaId));

        horariodeentregaRepository.delete(horariodeentrega);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}