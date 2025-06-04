package com.psigenda.psigenda.domain.dto.response;

import lombok.Builder;

@Builder
public record PacienteSummary(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String cpf
) {
}
