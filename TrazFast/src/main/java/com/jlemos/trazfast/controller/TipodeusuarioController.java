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

import com.jlemos.trazfast.repository.TipodeusuarioRepository;

import com.jlemos.trazfast.model.Tipodeusuario;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class TipodeusuarioController {
    @Autowired
    private TipodeusuarioRepository tipodeusuarioRepository;

    @GetMapping("/tipodeusuario")
    public List < Tipodeusuario > getAllTipodeusuario() {
        return tipodeusuarioRepository.findAll();
    }

    @GetMapping("/tipodeusuario/{id}")
    public ResponseEntity < Tipodeusuario > getTipodeusuarioById(@PathVariable(value = "id") Long tipodeusuarioId)
    throws ResourceNotFoundException {
        Tipodeusuario tipodeusuario = tipodeusuarioRepository.findById(tipodeusuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Tipodeusuario nao encontrada para id :: " + tipodeusuarioId));
        return ResponseEntity.ok().body(tipodeusuario);
    }

    @PostMapping("/tipodeusuario")
    public Tipodeusuario createTipodeusuario(@Valid @RequestBody Tipodeusuario tipodeusuario) {
        return tipodeusuarioRepository.save(tipodeusuario);
    }

    @PutMapping("/tipodeusuario/{id}")
    public ResponseEntity < Tipodeusuario > updateTipodeusuario(@PathVariable(value = "id") Long tipodeusuarioId,
        @Valid @RequestBody Tipodeusuario tipodeusuarioDetails) throws ResourceNotFoundException {
        Tipodeusuario tipodeusuario = tipodeusuarioRepository.findById(tipodeusuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Tipodeusuario não encontrada para id :: " + tipodeusuarioId));

        
        
        final Tipodeusuario updatedTipodeusuario = tipodeusuarioRepository.save(tipodeusuario);
        return ResponseEntity.ok(updatedTipodeusuario);
    }

    @DeleteMapping("/tipodeusuario/{id}")
    public Map < String, Boolean > deleteTipodeusuario(@PathVariable(value = "id") Long tipodeusuarioId)
    throws ResourceNotFoundException {
        Tipodeusuario tipodeusuario = tipodeusuarioRepository.findById(tipodeusuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Tipodeusuario não encontrada para id :: " + tipodeusuarioId));

        tipodeusuarioRepository.delete(tipodeusuario);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}