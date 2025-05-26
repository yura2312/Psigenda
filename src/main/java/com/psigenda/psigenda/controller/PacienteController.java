package com.psigenda.psigenda.controller;

import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        Paciente savedPaciente = service.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPaciente);
    }

    @GetMapping()
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> pacienteList = service.findAll();
        return ResponseEntity.ok(pacienteList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> findById(@PathVariable Long id){
        Optional<Paciente> paciente = service.findById(id);
        return paciente
                .map(foundPaciente -> ResponseEntity.ok(paciente))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
