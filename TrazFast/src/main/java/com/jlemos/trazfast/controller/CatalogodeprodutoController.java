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

import com.jlemos.trazfast.repository.CatalogodeprodutoRepository;

import com.jlemos.trazfast.model.Catalogodeproduto;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class CatalogodeprodutoController {
    @Autowired
    private CatalogodeprodutoRepository catalogodeprodutoRepository;

    @GetMapping("/catalogodeproduto")
    public List < Catalogodeproduto > getAllCatalogodeproduto() {
        return catalogodeprodutoRepository.findAll();
    }

    @GetMapping("/catalogodeproduto/{id}")
    public ResponseEntity < Catalogodeproduto > getCatalogodeprodutoById(@PathVariable(value = "id") Long catalogodeprodutoId)
    throws ResourceNotFoundException {
        Catalogodeproduto catalogodeproduto = catalogodeprodutoRepository.findById(catalogodeprodutoId)
            .orElseThrow(() -> new ResourceNotFoundException("Catalogodeproduto nao encontrada para id :: " + catalogodeprodutoId));
        return ResponseEntity.ok().body(catalogodeproduto);
    }

    @PostMapping("/catalogodeproduto")
    public Catalogodeproduto createCatalogodeproduto(@Valid @RequestBody Catalogodeproduto catalogodeproduto) {
        return catalogodeprodutoRepository.save(catalogodeproduto);
    }

    @PutMapping("/catalogodeproduto/{id}")
    public ResponseEntity < Catalogodeproduto > updateCatalogodeproduto(@PathVariable(value = "id") Long catalogodeprodutoId,
        @Valid @RequestBody Catalogodeproduto catalogodeprodutoDetails) throws ResourceNotFoundException {
        Catalogodeproduto catalogodeproduto = catalogodeprodutoRepository.findById(catalogodeprodutoId)
            .orElseThrow(() -> new ResourceNotFoundException("Catalogodeproduto não encontrada para id :: " + catalogodeprodutoId));

        
        
        final Catalogodeproduto updatedCatalogodeproduto = catalogodeprodutoRepository.save(catalogodeproduto);
        return ResponseEntity.ok(updatedCatalogodeproduto);
    }

    @DeleteMapping("/catalogodeproduto/{id}")
    public Map < String, Boolean > deleteCatalogodeproduto(@PathVariable(value = "id") Long catalogodeprodutoId)
    throws ResourceNotFoundException {
        Catalogodeproduto catalogodeproduto = catalogodeprodutoRepository.findById(catalogodeprodutoId)
            .orElseThrow(() -> new ResourceNotFoundException("Catalogodeproduto não encontrada para id :: " + catalogodeprodutoId));

        catalogodeprodutoRepository.delete(catalogodeproduto);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}