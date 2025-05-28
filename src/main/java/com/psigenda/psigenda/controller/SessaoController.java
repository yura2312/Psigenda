package com.psigenda.psigenda.controller;

import com.psigenda.psigenda.domain.dto.request.SessaoRequest;
import com.psigenda.psigenda.domain.dto.response.SessaoResponse;
import com.psigenda.psigenda.domain.entity.Sessao;
import com.psigenda.psigenda.mapper.SessaoMapper;
import com.psigenda.psigenda.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessoes")
public class SessaoController {

    private final SessaoService service;

    @GetMapping
    public ResponseEntity<List<SessaoResponse>> findAll() {
        List<SessaoResponse> responseList = service.findAll()
                .stream()
                .map(SessaoMapper::toSessaoResponse)
                .toList();
        return ResponseEntity.ok(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessaoResponse> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(found -> ResponseEntity.ok(SessaoMapper.toSessaoResponse(found)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public void delete(Long id){
        service.delete(id);
    }

    @PostMapping
    public ResponseEntity<SessaoResponse> save(@RequestBody SessaoRequest sessaoRequest){
        Sessao Sessao = SessaoMapper.toSessao(sessaoRequest);
        service.save(Sessao);
        SessaoResponse sessaoResponse = SessaoMapper.toSessaoResponse(Sessao);
        return ResponseEntity.ok(sessaoResponse);
    }

}

