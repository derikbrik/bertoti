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

import com.jlemos.trazfast.repository.UsuarioRepository;

import com.jlemos.trazfast.model.Usuario;
import com.jlemos.trazfast.ResourceNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List < Usuario > getAllUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity < Usuario > getUsuarioById(@PathVariable(value = "id") Long usuarioId)
    throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario nao encontrada para id :: " + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/usuario")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity < Usuario > updateUsuario(@PathVariable(value = "id") Long usuarioId,
        @Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrada para id :: " + usuarioId));

        
        
        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/usuario/{id}")
    public Map < String, Boolean > deleteUsuario(@PathVariable(value = "id") Long usuarioId)
    throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new ResourceNotFoundException("Usuario não encontrada para id :: " + usuarioId));

        usuarioRepository.delete(usuario);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}