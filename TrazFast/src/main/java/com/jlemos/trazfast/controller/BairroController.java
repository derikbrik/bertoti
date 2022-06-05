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

import com.jlemos.trazfast.repository.BairroRepository;

import com.jlemos.trazfast.model.Bairro;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class BairroController {
    @Autowired
    private BairroRepository bairroRepository;

    @GetMapping("/bairro")
    public List < Bairro > getAllBairro() {
        return bairroRepository.findAll();
    }

    @GetMapping("/bairro/{id}")
    public ResponseEntity < Bairro > getBairroById(@PathVariable(value = "id") Long bairroId)
    throws ResourceNotFoundException {
        Bairro bairro = bairroRepository.findById(bairroId)
            .orElseThrow(() -> new ResourceNotFoundException("Bairro nao encontrado para id :: " + bairroId));
        return ResponseEntity.ok().body(bairro);
    }

    @PostMapping("/bairro")
    public Bairro createBairro(@Valid @RequestBody Bairro bairro) {
        return bairroRepository.save(bairro);
    }

    @PutMapping("/bairro/{id}")
    public ResponseEntity < Bairro > updateBairro(@PathVariable(value = "id") Long bairroId,
        @Valid @RequestBody Bairro bairroDetails) throws ResourceNotFoundException {
        Bairro bairro = bairroRepository.findById(bairroId)
            .orElseThrow(() -> new ResourceNotFoundException("Bairro não encontrado para id :: " + bairroId));

        
        
        final Bairro updatedBairro = bairroRepository.save(bairro);
        return ResponseEntity.ok(updatedBairro);
    }

    @DeleteMapping("/bairro/{id}")
    public Map < String, Boolean > deleteBairro(@PathVariable(value = "id") Long bairroId)
    throws ResourceNotFoundException {
        Bairro bairro = bairroRepository.findById(bairroId)
            .orElseThrow(() -> new ResourceNotFoundException("Bairro não encontrado para id :: " + bairroId));

        bairroRepository.delete(bairro);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}