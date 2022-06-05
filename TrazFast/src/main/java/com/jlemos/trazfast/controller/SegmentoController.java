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

import com.jlemos.trazfast.repository.SegmentoRepository;

import com.jlemos.trazfast.model.Segmento;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class SegmentoController {
    @Autowired
    private SegmentoRepository segmentoRepository;

    @GetMapping("/segmento")
    public List < Segmento > getAllSegmento() {
        return segmentoRepository.findAll();
    }

    @GetMapping("/segmento/{id}")
    public ResponseEntity < Segmento > getSegmentoById(@PathVariable(value = "id") Long segmentoId)
    throws ResourceNotFoundException {
        Segmento segmento = segmentoRepository.findById(segmentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Segmento nao encontrada para id :: " + segmentoId));
        return ResponseEntity.ok().body(segmento);
    }

    @PostMapping("/segmento")
    public Segmento createSegmento(@Valid @RequestBody Segmento segmento) {
        return segmentoRepository.save(segmento);
    }

    @PutMapping("/segmento/{id}")
    public ResponseEntity < Segmento > updateSegmento(@PathVariable(value = "id") Long segmentoId,
        @Valid @RequestBody Segmento segmentoDetails) throws ResourceNotFoundException {
        Segmento segmento = segmentoRepository.findById(segmentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Segmento não encontrada para id :: " + segmentoId));

        
        
        final Segmento updatedSegmento = segmentoRepository.save(segmento);
        return ResponseEntity.ok(updatedSegmento);
    }

    @DeleteMapping("/segmento/{id}")
    public Map < String, Boolean > deleteSegmento(@PathVariable(value = "id") Long segmentoId)
    throws ResourceNotFoundException {
        Segmento segmento = segmentoRepository.findById(segmentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Segmento não encontrada para id :: " + segmentoId));

        segmentoRepository.delete(segmento);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}