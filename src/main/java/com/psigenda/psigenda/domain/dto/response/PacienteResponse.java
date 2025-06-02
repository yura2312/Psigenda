package com.psigenda.psigenda.domain.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record PacienteResponse(
        Long id,
        String nome,
        String sobrenome,
        String email,
        Boolean planoDeSaude,
        Long cpf,
        List<SessaoSummary> sessoes
) {
}
