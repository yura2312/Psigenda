package com.psigenda.psigenda.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Psicologo;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SessaoResponse(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime comecoSessao,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime fimSessao,
        String descricao,
        Paciente paciente,
        Psicologo psicologo
) {
}
