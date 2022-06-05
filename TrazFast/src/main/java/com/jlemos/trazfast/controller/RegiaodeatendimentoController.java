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

import com.jlemos.trazfast.repository.RegiaodeatendimentoRepository;

import com.jlemos.trazfast.model.Regiaodeatendimento;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RegiaodeatendimentoController {
    @Autowired
    private RegiaodeatendimentoRepository regiaodeatendimentoRepository;

    @GetMapping("/regiaodeatendimento")
    public List < Regiaodeatendimento > getAllRegiaodeatendimento() {
        return regiaodeatendimentoRepository.findAll();
    }

    @GetMapping("/regiaodeatendimento/{id}")
    public ResponseEntity < Regiaodeatendimento > getRegiaodeatendimentoById(@PathVariable(value = "id") Long regiaodeatendimentoId)
    throws ResourceNotFoundException {
        Regiaodeatendimento regiaodeatendimento = regiaodeatendimentoRepository.findById(regiaodeatendimentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Regiaodeatendimento nao encontrada para id :: " + regiaodeatendimentoId));
        return ResponseEntity.ok().body(regiaodeatendimento);
    }

    @PostMapping("/regiaodeatendimento")
    public Regiaodeatendimento createRegiaodeatendimento(@Valid @RequestBody Regiaodeatendimento regiaodeatendimento) {
        return regiaodeatendimentoRepository.save(regiaodeatendimento);
    }

    @PutMapping("/regiaodeatendimento/{id}")
    public ResponseEntity < Regiaodeatendimento > updateRegiaodeatendimento(@PathVariable(value = "id") Long regiaodeatendimentoId,
        @Valid @RequestBody Regiaodeatendimento regiaodeatendimentoDetails) throws ResourceNotFoundException {
        Regiaodeatendimento regiaodeatendimento = regiaodeatendimentoRepository.findById(regiaodeatendimentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Regiaodeatendimento não encontrada para id :: " + regiaodeatendimentoId));

        
        
        final Regiaodeatendimento updatedRegiaodeatendimento = regiaodeatendimentoRepository.save(regiaodeatendimento);
        return ResponseEntity.ok(updatedRegiaodeatendimento);
    }

    @DeleteMapping("/regiaodeatendimento/{id}")
    public Map < String, Boolean > deleteRegiaodeatendimento(@PathVariable(value = "id") Long regiaodeatendimentoId)
    throws ResourceNotFoundException {
        Regiaodeatendimento regiaodeatendimento = regiaodeatendimentoRepository.findById(regiaodeatendimentoId)
            .orElseThrow(() -> new ResourceNotFoundException("Regiaodeatendimento não encontrada para id :: " + regiaodeatendimentoId));

        regiaodeatendimentoRepository.delete(regiaodeatendimento);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}