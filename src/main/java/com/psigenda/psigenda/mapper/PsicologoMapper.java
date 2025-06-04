package com.psigenda.psigenda.mapper;

import com.psigenda.psigenda.domain.dto.request.PsicologoRequest;
import com.psigenda.psigenda.domain.dto.response.PsicologoResponse;
import com.psigenda.psigenda.domain.dto.response.SessaoSummary;
import com.psigenda.psigenda.domain.entity.Psicologo;
import com.psigenda.psigenda.domain.entity.Sessao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PsicologoMapper {

    public static Psicologo toPsicologo(PsicologoRequest psicologoRequest) {

            List<Sessao> sessoes = Optional.ofNullable(psicologoRequest.sessoes())
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(sessaoId -> Sessao.builder().id(sessaoId).build())
                    .toList();

        return Psicologo
                .builder()
                .nome(psicologoRequest.nome())
                .sobrenome(psicologoRequest.sobrenome())
                .email(psicologoRequest.email())
                .crp(psicologoRequest.crp())
                .sessoes(sessoes)
                .build();
    }

    public static PsicologoResponse toPsicologoResponse(Psicologo psicologo) {

        List<SessaoSummary> sessoes = psicologo.getSessoes().stream()
                .map(sessaoList ->{ String psicologoFullName = psicologo.getNome() + " " + psicologo.getSobrenome();
        String pacienteFullName = sessaoList.getPaciente().getNome() + " " + sessaoList.getPaciente().getSobrenome();

        return SessaoSummary.builder()
                .comecoSessao(sessaoList.getComecoSessao())
                .fimSessao(sessaoList.getFimSessao())
                .descricao(sessaoList.getDescricao())
                .psicologo(psicologoFullName)
                .paciente(pacienteFullName)
                .build();})
                .toList();
        return PsicologoResponse
                .builder()
                .id(psicologo.getId())
                .nome(psicologo.getNome())
                .sobrenome(psicologo.getSobrenome())
                .email(psicologo.getEmail())
                .crp(psicologo.getCrp())
                .sessoes(sessoes)
                .build();
    }
}
