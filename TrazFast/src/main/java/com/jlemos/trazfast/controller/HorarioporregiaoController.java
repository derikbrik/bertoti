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

import com.jlemos.trazfast.repository.HorarioporregiaoRepository;

import com.jlemos.trazfast.model.Horarioporregiao;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class HorarioporregiaoController {
    @Autowired
    private HorarioporregiaoRepository horarioporregiaoRepository;

    @GetMapping("/horarioporregiao")
    public List < Horarioporregiao > getAllHorarioporregiao() {
        return horarioporregiaoRepository.findAll();
    }

    @GetMapping("/horarioporregiao/{id}")
    public ResponseEntity < Horarioporregiao > getHorarioporregiaoById(@PathVariable(value = "id") Long horarioporregiaoId)
    throws ResourceNotFoundException {
        Horarioporregiao horarioporregiao = horarioporregiaoRepository.findById(horarioporregiaoId)
            .orElseThrow(() -> new ResourceNotFoundException("Horarioporregiao nao encontrada para id :: " + horarioporregiaoId));
        return ResponseEntity.ok().body(horarioporregiao);
    }

    @PostMapping("/horarioporregiao")
    public Horarioporregiao createHorarioporregiao(@Valid @RequestBody Horarioporregiao horarioporregiao) {
        return horarioporregiaoRepository.save(horarioporregiao);
    }

    @PutMapping("/horarioporregiao/{id}")
    public ResponseEntity < Horarioporregiao > updateHorarioporregiao(@PathVariable(value = "id") Long horarioporregiaoId,
        @Valid @RequestBody Horarioporregiao horarioporregiaoDetails) throws ResourceNotFoundException {
        Horarioporregiao horarioporregiao = horarioporregiaoRepository.findById(horarioporregiaoId)
            .orElseThrow(() -> new ResourceNotFoundException("Horarioporregiao não encontrada para id :: " + horarioporregiaoId));

        
        
        final Horarioporregiao updatedHorarioporregiao = horarioporregiaoRepository.save(horarioporregiao);
        return ResponseEntity.ok(updatedHorarioporregiao);
    }

    @DeleteMapping("/horarioporregiao/{id}")
    public Map < String, Boolean > deleteHorarioporregiao(@PathVariable(value = "id") Long horarioporregiaoId)
    throws ResourceNotFoundException {
        Horarioporregiao horarioporregiao = horarioporregiaoRepository.findById(horarioporregiaoId)
            .orElseThrow(() -> new ResourceNotFoundException("Horarioporregiao não encontrada para id :: " + horarioporregiaoId));

        horarioporregiaoRepository.delete(horarioporregiao);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}