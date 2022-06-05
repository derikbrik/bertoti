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

import com.jlemos.trazfast.repository.SubcategoriaRepository;

import com.jlemos.trazfast.model.Subcategoria;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class SubcategoriaController {
    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @GetMapping("/subcategoria")
    public List < Subcategoria > getAllSubcategoria() {
        return subcategoriaRepository.findAll();
    }

    @GetMapping("/subcategoria/{id}")
    public ResponseEntity < Subcategoria > getSubcategoriaById(@PathVariable(value = "id") Long subcategoriaId)
    throws ResourceNotFoundException {
        Subcategoria subcategoria = subcategoriaRepository.findById(subcategoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Subcategoria nao encontrada para id :: " + subcategoriaId));
        return ResponseEntity.ok().body(subcategoria);
    }

    @PostMapping("/subcategoria")
    public Subcategoria createSubcategoria(@Valid @RequestBody Subcategoria subcategoria) {
        return subcategoriaRepository.save(subcategoria);
    }

    @PutMapping("/subcategoria/{id}")
    public ResponseEntity < Subcategoria > updateSubcategoria(@PathVariable(value = "id") Long subcategoriaId,
        @Valid @RequestBody Subcategoria subcategoriaDetails) throws ResourceNotFoundException {
        Subcategoria subcategoria = subcategoriaRepository.findById(subcategoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Subcategoria não encontrada para id :: " + subcategoriaId));

        
        
        final Subcategoria updatedSubcategoria = subcategoriaRepository.save(subcategoria);
        return ResponseEntity.ok(updatedSubcategoria);
    }

    @DeleteMapping("/subcategoria/{id}")
    public Map < String, Boolean > deleteSubcategoria(@PathVariable(value = "id") Long subcategoriaId)
    throws ResourceNotFoundException {
        Subcategoria subcategoria = subcategoriaRepository.findById(subcategoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Subcategoria não encontrada para id :: " + subcategoriaId));

        subcategoriaRepository.delete(subcategoria);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}