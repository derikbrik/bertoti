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

import com.jlemos.trazfast.repository.AssinaturaRepository;

import com.jlemos.trazfast.model.Assinatura;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AssinaturaController {
    @Autowired
    private AssinaturaRepository assinaturaRepository;

    @GetMapping("/assinatura")
    public List < Assinatura > getAllAssinatura() {
        return assinaturaRepository.findAll();
    }

    @GetMapping("/assinatura/{id}")
    public ResponseEntity < Assinatura > getAssinaturaById(@PathVariable(value = "id") Long assinaturaId)
    throws ResourceNotFoundException {
        Assinatura assinatura = assinaturaRepository.findById(assinaturaId)
            .orElseThrow(() -> new ResourceNotFoundException("Assinatura nao encontrada para id :: " + assinaturaId));
        return ResponseEntity.ok().body(assinatura);
    }

    @PostMapping("/assinatura")
    public Assinatura createAssinatura(@Valid @RequestBody Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    @PutMapping("/assinatura/{id}")
    public ResponseEntity < Assinatura > updateAssinatura(@PathVariable(value = "id") Long assinaturaId,
        @Valid @RequestBody Assinatura assinaturaDetails) throws ResourceNotFoundException {
        Assinatura assinatura = assinaturaRepository.findById(assinaturaId)
            .orElseThrow(() -> new ResourceNotFoundException("Assinatura não encontrada para id :: " + assinaturaId));

        
        
        final Assinatura updatedAssinatura = assinaturaRepository.save(assinatura);
        return ResponseEntity.ok(updatedAssinatura);
    }

    @DeleteMapping("/assinatura/{id}")
    public Map < String, Boolean > deleteAssinatura(@PathVariable(value = "id") Long assinaturaId)
    throws ResourceNotFoundException {
        Assinatura assinatura = assinaturaRepository.findById(assinaturaId)
            .orElseThrow(() -> new ResourceNotFoundException("Assinatura não encontrada para id :: " + assinaturaId));

        assinaturaRepository.delete(assinatura);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}