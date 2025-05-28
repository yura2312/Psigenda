package com.psigenda.psigenda.controller;

import com.psigenda.psigenda.domain.dto.request.PsicologoRequest;
import com.psigenda.psigenda.domain.dto.response.PsicologoResponse;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.mapper.PsicologoMapper;
import com.psigenda.psigenda.service.PsicologoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/psicologos")
public class PsicologoController {

    private final PsicologoService service;

    @PostMapping
    public ResponseEntity<PsicologoResponse> save(@RequestBody PsicologoRequest psicologoRequest){
        Psicologo psicologo = PsicologoMapper.toPsicologo(psicologoRequest);
        service.save(psicologo);
        PsicologoResponse savedPsicologo = PsicologoMapper.toPsicologoResponse(psicologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPsicologo);
    }

    @GetMapping()
    public ResponseEntity<List<PsicologoResponse>> findAll(){
        List<PsicologoResponse> psicologoList = service.findAll()
                .stream()
                .map(PsicologoMapper::toPsicologoResponse)
                .toList();
        return ResponseEntity.ok(psicologoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PsicologoResponse> findById(@PathVariable Long id){
        return service.findById(id)
                .map(found -> ResponseEntity.ok(PsicologoMapper.toPsicologoResponse(found)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
