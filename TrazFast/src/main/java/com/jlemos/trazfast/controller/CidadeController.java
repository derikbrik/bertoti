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

import com.jlemos.trazfast.repository.CidadeRepository;

import com.jlemos.trazfast.model.Cidade;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CidadeController {
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("/cidade")
    public List < Cidade > getAllCidade() {
        return cidadeRepository.findAll();
    }

    @GetMapping("/cidade/{id}")
    public ResponseEntity < Cidade > getCidadeById(@PathVariable(value = "id") Long cidadeId)
    throws ResourceNotFoundException {
        Cidade cidade = cidadeRepository.findById(cidadeId)
            .orElseThrow(() -> new ResourceNotFoundException("Cidade nao encontrada para id :: " + cidadeId));
        return ResponseEntity.ok().body(cidade);
    }

    @PostMapping("/cidade")
    public Cidade createCidade(@Valid @RequestBody Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @PutMapping("/cidade/{id}")
    public ResponseEntity < Cidade > updateCidade(@PathVariable(value = "id") Long cidadeId,
        @Valid @RequestBody Cidade cidadeDetails) throws ResourceNotFoundException {
        Cidade cidade = cidadeRepository.findById(cidadeId)
            .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada para id :: " + cidadeId));

        
        
        final Cidade updatedCidade = cidadeRepository.save(cidade);
        return ResponseEntity.ok(updatedCidade);
    }

    @DeleteMapping("/cidade/{id}")
    public Map < String, Boolean > deleteCidade(@PathVariable(value = "id") Long cidadeId)
    throws ResourceNotFoundException {
        Cidade cidade = cidadeRepository.findById(cidadeId)
            .orElseThrow(() -> new ResourceNotFoundException("Cidade não encontrada para id :: " + cidadeId));

        cidadeRepository.delete(cidade);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}