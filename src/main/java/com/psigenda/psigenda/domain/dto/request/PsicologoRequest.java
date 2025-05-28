package com.psigenda.psigenda.domain.dto.request;

import com.psigenda.psigenda.domain.entity.Sessao;

import java.util.List;

public record PsicologoRequest(
        String nome,
        String sobrenome,
        String email,
        Long crp,
        List<Long> sessoes) {
}
