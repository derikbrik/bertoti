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

import com.jlemos.trazfast.repository.DepartamentoRepository;

import com.jlemos.trazfast.model.Departamento;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping("/departamento")
    public List < Departamento > getAllDepartamento() {
        return departamentoRepository.findAll();
    }

    @GetMapping("/departamento/{id}")
    public ResponseEntity < Departamento > getDepartamentoById(@PathVariable(value = "id") Long departamentoId)
    throws ResourceNotFoundException {
        Departamento departamento = departamentoRepository.findById(departamentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Departamento nao encontrada para id :: " + departamentoId));
        return ResponseEntity.ok().body(departamento);
    }

    @PostMapping("/departamento")
    public Departamento createDepartamento(@Valid @RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @PutMapping("/departamento/{id}")
    public ResponseEntity < Departamento > updateDepartamento(@PathVariable(value = "id") Long departamentoId,
        @Valid @RequestBody Departamento departamentoDetails) throws ResourceNotFoundException {
        Departamento departamento = departamentoRepository.findById(departamentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrada para id :: " + departamentoId));

        
        
        final Departamento updatedDepartamento = departamentoRepository.save(departamento);
        return ResponseEntity.ok(updatedDepartamento);
    }

    @DeleteMapping("/departamento/{id}")
    public Map < String, Boolean > deleteDepartamento(@PathVariable(value = "id") Long departamentoId)
    throws ResourceNotFoundException {
        Departamento departamento = departamentoRepository.findById(departamentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Departamento não encontrada para id :: " + departamentoId));

        departamentoRepository.delete(departamento);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}