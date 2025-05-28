package com.psigenda.psigenda.domain.dto.response;

import lombok.Builder;

@Builder
public record PsicologoSummary(
        Long id,
        String nome,
        String sobrenome,
        String email,
        Long crp
) {
}
