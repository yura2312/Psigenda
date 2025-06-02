package com.psigenda.psigenda.domain.dto.response;

import com.psigenda.psigenda.domain.entity.Sessao;
import lombok.Builder;

import java.util.List;

@Builder
public record PsicologoResponse(
        Long id,
        String nome,
        String sobrenome,
        String email,
        Long crp,
        List<SessaoSummary> sessoes) {
}
