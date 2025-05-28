package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.PacienteRequest;
import com.psigenda.psigenda.domain.dto.response.PacienteResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSumary;
import com.psigenda.psigenda.domain.entity.Paciente;
import com.psigenda.psigenda.domain.entity.Sessao;

import java.util.List;

public class PacienteMapper {

    public static PacienteResponse toPacienteResponse(Paciente paciente) {

        List<SessaoSumary> sessoes = paciente.getSessoes()
                .stream()
                .map(sessao -> SessaoSumary
                        .builder()
                        .id(sessao.getId())
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

        List<Sessao> sessoes = pacienteRequest.sessoes()
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
