package com.psigenda.psigenda.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Psicologo;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;

public record SessaoRequest(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @FutureOrPresent
    LocalDateTime comecoSessao,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @Future
    LocalDateTime fimSessao,
    Long paciente,
    Long psicologo
) {
}
