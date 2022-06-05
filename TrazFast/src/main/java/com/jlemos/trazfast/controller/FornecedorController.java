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

import com.jlemos.trazfast.repository.FornecedorRepository;

import com.jlemos.trazfast.model.Fornecedor;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class FornecedorController {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("/fornecedor")
    public List < Fornecedor > getAllFornecedor() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("/fornecedor/{id}")
    public ResponseEntity < Fornecedor > getFornecedorById(@PathVariable(value = "id") Long fornecedorId)
    throws ResourceNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor nao encontrada para id :: " + fornecedorId));
        return ResponseEntity.ok().body(fornecedor);
    }

    @PostMapping("/fornecedor")
    public Fornecedor createFornecedor(@Valid @RequestBody Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @PutMapping("/fornecedor/{id}")
    public ResponseEntity < Fornecedor > updateFornecedor(@PathVariable(value = "id") Long fornecedorId,
        @Valid @RequestBody Fornecedor fornecedorDetails) throws ResourceNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrada para id :: " + fornecedorId));

        
        
        final Fornecedor updatedFornecedor = fornecedorRepository.save(fornecedor);
        return ResponseEntity.ok(updatedFornecedor);
    }

    @DeleteMapping("/fornecedor/{id}")
    public Map < String, Boolean > deleteFornecedor(@PathVariable(value = "id") Long fornecedorId)
    throws ResourceNotFoundException {
        Fornecedor fornecedor = fornecedorRepository.findById(fornecedorId)
            .orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrada para id :: " + fornecedorId));

        fornecedorRepository.delete(fornecedor);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}