package com.psigenda.psigenda.controller;

import com.psigenda.psigenda.doc.PacienteDoc;
import com.psigenda.psigenda.domain.dto.request.PacienteRequest;
import com.psigenda.psigenda.domain.dto.response.PacienteResponse;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.exception.PacienteException;
import com.psigenda.psigenda.mapper.PacienteMapper;
import com.psigenda.psigenda.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController implements PacienteDoc {
    private final PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponse> save(@RequestBody PacienteRequest pacienteRequest) {
        Paciente paciente = PacienteMapper.toPaciente(pacienteRequest);
        Paciente savedPaciente = service.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteMapper.toPacienteResponse(savedPaciente));
    }

    @GetMapping()
    public ResponseEntity<List<PacienteResponse>> findAll() {
        List<PacienteResponse> pacienteResponseList = service.findAll()
                .stream()
                .map(PacienteMapper::toPacienteResponse)
                .toList();
        return ResponseEntity.ok(pacienteResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(found -> ResponseEntity.ok(PacienteMapper.toPacienteResponse(found)))
                .orElseThrow(PacienteException::new);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
