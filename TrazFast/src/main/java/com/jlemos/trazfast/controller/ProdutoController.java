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

import com.jlemos.trazfast.repository.ProdutoRepository;

import com.jlemos.trazfast.model.Produto;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produto")
    public List < Produto > getAllProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity < Produto > getProdutoById(@PathVariable(value = "id") Long produtoId)
    throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ResourceNotFoundException("Produto nao encontrada para id :: " + produtoId));
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping("/produto")
    public Produto createProduto(@Valid @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity < Produto > updateProduto(@PathVariable(value = "id") Long produtoId,
        @Valid @RequestBody Produto produtoDetails) throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrada para id :: " + produtoId));

        
        
        final Produto updatedProduto = produtoRepository.save(produto);
        return ResponseEntity.ok(updatedProduto);
    }

    @DeleteMapping("/produto/{id}")
    public Map < String, Boolean > deleteProduto(@PathVariable(value = "id") Long produtoId)
    throws ResourceNotFoundException {
        Produto produto = produtoRepository.findById(produtoId)
            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrada para id :: " + produtoId));

        produtoRepository.delete(produto);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}