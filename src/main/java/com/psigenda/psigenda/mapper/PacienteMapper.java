package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.PacienteRequest;
import com.psigenda.psigenda.domain.dto.response.PacienteResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSummary;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Sessao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PacienteMapper {

    public static PacienteResponse toPacienteResponse(Paciente paciente) {

        List<SessaoSummary> sessoes = Optional.ofNullable(paciente.getSessoes())
                .orElse(Collections.emptyList())
                .stream()
                .map(sessao -> SessaoSummary
                        .builder()
                        .comecoSessao(sessao.getComecoSessao())
                        .fimSessao(sessao.getFimSessao())
                        .descricao(sessao.getDescricao())
                        .build())
                .toList();

        return PacienteResponse
                .builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sobrenome(paciente.getSobrenome())
                .cpf(paciente.getCpf())
                .email(paciente.getEmail())
                .planoDeSaude(paciente.getPlanoDeSaude())
                .sessoes(sessoes)
                .build();
    }

    public static Paciente toPaciente(PacienteRequest pacienteRequest) {

        List<Sessao> sessoes = Optional.ofNullable(pacienteRequest.sessoes())
                .orElse(Collections.emptyList())
                .stream()
                .map(sessaoId -> Sessao.builder().id(sessaoId).build())
                .toList();

        return Paciente
                .builder()
                .nome(pacienteRequest.nome())
                .sobrenome(pacienteRequest.sobrenome())
                .cpf(pacienteRequest.cpf())
                .email(pacienteRequest.email())
                .planoDeSaude(pacienteRequest.planoDeSaude())
                .sessoes(sessoes)
                .build();
    }

}
