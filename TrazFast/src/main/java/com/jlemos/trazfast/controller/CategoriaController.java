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

import com.jlemos.trazfast.repository.CategoriaRepository;

import com.jlemos.trazfast.model.Categoria;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categoria")
    public List < Categoria > getAllCategoria() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity < Categoria > getCategoriaById(@PathVariable(value = "id") Long categoriaId)
    throws ResourceNotFoundException {
        Categoria categoria = categoriaRepository.findById(categoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria nao encontrada para id :: " + categoriaId));
        return ResponseEntity.ok().body(categoria);
    }

    @PostMapping("/categoria")
    public Categoria createCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity < Categoria > updateCategoria(@PathVariable(value = "id") Long categoriaId,
        @Valid @RequestBody Categoria categoriaDetails) throws ResourceNotFoundException {
        Categoria categoria = categoriaRepository.findById(categoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada para id :: " + categoriaId));

        
        
        final Categoria updatedCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/categoria/{id}")
    public Map < String, Boolean > deleteCategoria(@PathVariable(value = "id") Long categoriaId)
    throws ResourceNotFoundException {
        Categoria categoria = categoriaRepository.findById(categoriaId)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada para id :: " + categoriaId));

        categoriaRepository.delete(categoria);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}