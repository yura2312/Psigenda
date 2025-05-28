package com.psigenda.psigenda.domain.dto.response;

import com.psigenda.psigenda.domain.entity.Sessao;
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
        List<Sessao> sessoes
) {
}
