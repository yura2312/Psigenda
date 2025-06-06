package com.psigenda.psigenda.domain.dto.request;

import java.util.List;

public record PacienteRequest(
        String nome,
        String sobrenome,
        String email,
        Boolean planoDeSaude,
        String cpf,
        List<Long> sessoes
) {
}
