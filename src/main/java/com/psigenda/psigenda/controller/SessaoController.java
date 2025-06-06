package com.psigenda.psigenda.controller;

import com.psigenda.psigenda.doc.SessaoDoc;
import com.psigenda.psigenda.domain.dto.request.SessaoRequest;
import com.psigenda.psigenda.domain.dto.response.SessaoResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSummary;
import com.psigenda.psigenda.domain.entity.Sessao;
import com.psigenda.psigenda.exception.SessaoException;
import com.psigenda.psigenda.mapper.SessaoMapper;
import com.psigenda.psigenda.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sessoes")
public class SessaoController implements SessaoDoc {

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
    public ResponseEntity<SessaoSummary> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(found -> ResponseEntity.ok(SessaoMapper.toSessaoSummary(found)))
                .orElseThrow(SessaoException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PostMapping
    public ResponseEntity<SessaoResponse> save(@RequestBody SessaoRequest sessaoRequest){
        Sessao Sessao = SessaoMapper.toSessao(sessaoRequest);
        service.save(Sessao);
        SessaoResponse sessaoResponse = SessaoMapper.toSessaoResponse(Sessao);
        return ResponseEntity.ok(sessaoResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SessaoSummary> patch(@PathVariable Long id, @RequestBody SessaoRequest sessaoRequest){
        Sessao updatedSessao = SessaoMapper.toSessao(sessaoRequest);
        service.patch(id, updatedSessao);
        SessaoSummary sessaoResponse = SessaoMapper.toSessaoSummary(updatedSessao);
        return ResponseEntity.ok(sessaoResponse);
    }

}

