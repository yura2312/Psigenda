package com.psigenda.psigenda.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
//TODO: Fazer isto retornar o paciente e o psicologo só os nomes.
@Builder
public record SessaoSummary(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime comecoSessao,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
        LocalDateTime fimSessao,
        String descricao,
        String psicologo,
        String paciente
) {
}
